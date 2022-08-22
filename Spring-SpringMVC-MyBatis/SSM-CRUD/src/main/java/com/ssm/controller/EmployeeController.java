package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;
import com.ssm.service.norm.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public static final String FIND_EMPLOYEES_BY_PAGE_NUMS_1 = "forward:/employee/findEmployeesByPageNums/1";

    @Autowired
    EmployeeService employeeService;

//    POST、DELETE、PUT、GET，
// @PathVariable是获取url上数据的。
// @RequestParam获取请求参数的（包括post表单提交）

//        eid
//        empName
//        age
//        email
//        sex
//        did

    //    更新（更新之前记录当前页数、后面好定位还原）

    //    新增员工 @RequestBody
    /*
     *
     * 以下是模板设计模式：具体的转换通过HttpMessageConvert的实现类最终实现
     *
     * 入参解析（类名后缀大多是Processor、resolver（90%））
     *       1.调用符合条件的参数解析器的this.resolvers.resolveArgument --> getArgumentResolver方法，
     *          假设满足了RequestResponseBodyMethodProcessor 的 supportsParameter，那么判断时这个参数一定是标注了@RequestBody的、
     *           迭代HttpMessageConverter的实现类的canRead方法判断（.getHeaders().getContentType()--传入获取的媒体类型以及这个方法参数class类型）
     *           如果能就就是调用这个实现类的 read方法，不能转换则迭代，转换成功直接返回这个值到 args[i] = this.resolvers.resolveArgument
     *
     *           。。。。。。。。反复执行这个1过程，直到把参数解析完成 底层对某个控制器方法的的每个参数分别解析，先遍历所有的参数解析器，
     *                         以入参的类型或者这个参数所带的注解为条件来判断是否适合解析（这是大前提 中间会把找到解析器缓存）
     *
     *  带Processor后缀的类实现了HTTPinputMessage 和 HTTPoutputMessage 两个接口具有处理入参，返回值的能力
     *
     * 返回值解析（类名后缀大多是Processor、handler（90%））
     *       2.执行控制器方法得到返回值后，通过迭代返回值处理器 假设又满足了RequestResponseBodyMethodProcessor 的 supportsReturnType
     *            那么判断时这个返回值也一定是标注了 @ResponseBody的,（但是这里没做缓存） 之后直接调用handleReturnValue：
     *           2.1、然后 开始内容协商 this.getAcceptableMediaTypes(request) 注意： 这个方法内部会从ContentNegotiationManager
     *                  从服务器自带的协商策略集中比对媒体类型，这个服务器是否支持该媒体类型（自定义的Accept需要注意这点）
     *                  ; --看客户要啥类型的返回值
     *           2.2、然后 服务器调用 getProducibleMediaTypes 看看哪些 HttpMessageConvert能够canWrite、如果能就调用这个实现类的
     *               getSupportedMediaTypes(valueClass) 得到它的"能力"加入到服务器能力集合，最后返回
     *
     *           2.3、服务器通过两个集合的能力比对 获取要使用的媒体类型，然后按权重排序选择一个最合适的响应类型
     *                  最后通过迭代HttpMessageConvert的实现类 分别调用canWrite 满足条件则开始写入响应流并且指定响应类型Content-Type
     *
     * @RequestBody->read（能够获取前端传过来的json数据）:
     *
     * @ResponseBody->write：内容（响应时要提前根据客户端的Accept，与服务端的内容协商（也有基于url 中参数的。。。））
     * */

//    Http传递请求体信息，最终会被封装进com.fasterxml.jackson.core.json.UTF8StreamJsonParser中
//    (提示：Spring采用CharacterEncodingFilter设置了默认编码为UTF-8)，
//    然后在public class BeanDeserializer extends BeanDeserializerBase implements java.io.Serializable 类中，
//    通过 public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt) throws IOException方法进行解析。

    @PostMapping("/")
    public String addNewEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            //可以封装成一个Information返回
            return "forward:/employee/sendMessage/"+Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
        }
        employeeService.addEmployee(employee);
        return FIND_EMPLOYEES_BY_PAGE_NUMS_1;
    }

    @RequestMapping("/sendMessage/{msg}")
    @ResponseBody
    public String sendMessage(@PathVariable("msg") String msg){
        return msg;
    }

    //    删除员工
    @DeleteMapping("/{eids}")
    @ResponseBody
    public String deleteEmployee(@PathVariable("eids") String eids) {
        Integer integer;
        if (!eids.contains(",")){
            integer = employeeService.delEmployee(Integer.valueOf(eids));
        }else{
            integer = employeeService.delBatchEmp(eids);
        }
        return integer > 0 ? "删除成功！！！":"删除失败！！！";
    }

    //    编辑员工信息
    @PutMapping("/")
    public String editEmployeeInfo(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return FIND_EMPLOYEES_BY_PAGE_NUMS_1;
    }

    @RequestMapping(value = "/findEmployeesByPageNums/{pageNums}")
    public @ResponseBody
    PageInfo<Employee> findEmployeesByPageNums(@PathVariable("pageNums") Integer pageNums) {
        return employeeService.findEmployeesByPageNums(pageNums);
    }

}
