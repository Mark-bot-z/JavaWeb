1. Cookie
   1. 创建Cookie对象
   2. 在客户端保存Cookie
   3. 设置Cookie的有效时长
      cookie.setMaxAge(60)  ， 设置cookie的有效时长是60秒
      cookie.setDomain(pattern);
      cookie.setPath(uri);
   4. Cookie的应用：
     4-1: 记住用户名和密码十天 setMaxAge(60 * 60 * 24 * 10)
     4-2: 十天免登录

2. Kaptcha
   1. 为什么需要验证码
   2. kaptcha如何使用:
      - 添加jar
      - 在web.xml文件中注册KaptchaServlet，并设置验证码图片的相关属性
      - 在html页面上编写一个img标签，然后设置src等于KaptchaServlet对应的url-pattern
   3. kaptcha验证码图片的各个属性在常量接口：Constants中
   4. KaptchaServlet在生成验证码图片时，会同时将验证码信息保存到session中
      因此，我们在注册请求时，首先将用户文本框中输入的验证码值和session中保存的值进行比较，相等，则进行注册

3. JS - Exp
   1)正则表达式的使用三步骤：
       1. 定义正则表达式对象
          正则表达式定义有两个方式：
          1) 对象形式
             var reg = new RegExp("abc")
          2) 直接量形式
             var reg = /abc/;
          3) 匹配模式：
           - g 全局匹配
           - i 忽略大小写匹配
           - m 多行匹配
           - gim这三个可以组合使用，不区分先后顺序
             例如： var reg = /abc/gim , var reg = new RegExp("abc","gim");
       2. 定义待校验的字符串
       3. 校验
   2)元字符
     | .    | 匹配除换行字符以外的任意字符。                               |
     | \w   | 匹配字母或数字或下划线等价于[a-zA-Z0-9_]                     |
     | \W   | 匹配任何非单词字符。等价于[^A-Za-z0-9_]                      |
     | \s   | 匹配任意的空白符，包括空格、制表符、换页符等等。等价于[\f\n\r\t\v]。 |
     | \S   | 匹配任何非空白字符。等价于[^\f\n\r\t\v]。                    |
     | \d   | 匹配数字。等价于[0-9]。                                      |
     | \D   | 匹配一个非数字字符。等价于[^0-9]                             |
     | \b   | 匹配单词的开始或结束                                         |
     | ^    | 匹配字符串的开始，但在[]中使用表示取反                       |
     | $    | 匹配字符串的结束

   3)[]表示集合
   | [字符列表]  | 正则表达式：[abc] 含义：目标字符串包含abc中的任何一个字符 目标字符串：plain 是否匹配：是 原因：plain中的“a”在列表“abc”中 | 目标     字符串中任何一个字符出现在字符列表中就算匹配。 |
   | [^字符列表] | [^abc] 含义：目标字符串包含abc以外的任何一个字符 目标字符串：plain 是否匹配：是 原因：plain中包含“p”、“l”、“i”、“n” | 匹配字符       列表中未包含的任意字符。                   |
   | [字符范围]  | 正则表达式：[a-z] 含义：所有小写英文字符组成的字符列表 正则表达式：[A-Z] 含义：所有大写英文字符组成的字符列表 | 匹配指定范围内的任意       字符。                         |
     [abc] 表示 a或者b或者c
     [^abc] 表示取反，只要不是a不是b不是c就匹配
     [a-c] 表示a到c这个范围匹配

   4) 出现的次数
   | *     | 出现零次或多次 |
   | +     | 出现一次或多次 |
   | ?     | 出现零次或一次 |
   | {n}   | 出现n次        |
   | {n,}  | 出现n次或多次  |
   | {n,m} | 出现n到m次     |

     * 表示多次 （0 ~ n ）
     + 至少一次 ( >=1 )
     ? 最多一次 (0 ~ 1)
     {n} 出现n次
     {n,} 出现n次或者多次
     {n,m} 出现n到m次

 1. 注册页面表单验证
    1) <form>有一个事件 onsubmit ,
        onsubmit="return false" , 那么表单点击提交按钮时不会提交
        onsubmit="return true" ,  那么表单点击提交按钮时会提交

    2) 获取文档中某一个节点的方式：
        //DOM:Document
        //var unameTxt = document.getElementById("unameTxt");
        //BOM:Browser
        //document.forms[0].uname


  2. 原生的Ajax（了解）
    第一步： 客户端发送异步请求；并绑定对结果处理的回调函数
    1) <input type="text" name="uname" onblur="ckUname()"/>
    2) 定义ckUname方法：
       - 创建XMLHttpRequest对象
       - XMLHttpRequest对象操作步骤：
         - open(url,"GET",true)
         - onreadyStateChange 设置回调
         - send() 发送请求
       - 在回调函数中需要判断XMLHttpRequest对象的状态:
         readyState(0-4) , status(200)
    第二步：服务器端做校验，然后将校验结果响应给客户端



    Ajax : 异步的JavaScript and XML
    目的： 用来发送异步的请求，然后当服务器给我响应的时候再进行回调操作
    好处： 提高用户体验；局部刷新：降低服务器负担、减轻浏览器压力、减轻网络带宽压力
    开发步骤：
      1) 创建XMLHttpRequest
      2) 调用open进行设置："GET" , URL , true
      3) 绑定状态改变时执行的回调函数 - onreadystatechange
      4) 发送请求 - send()
      5) 编写回调函数，在回调函数中，我们只对XMLHttpRequest的readystate为4的时候感兴趣
                                我们只对XMLHttpRequest的status为200的时候感兴趣

    0: (Uninitialized) the send( ) method has not yet been invoked.
    1: (Loading) the send( ) method has been invoked, request in progress.
    2: (Loaded) the send( ) method has completed, entire response received.
    3: (Interactive) the response is being parsed.
    4: (Completed) the response has been parsed, is ready for harvesting.

    0 － （未初始化）还没有调用send()方法
    1 － （载入）已调用send()方法，正在发送请求
    2 － （载入完成）send()方法执行完成，已经接收到全部响应内容
    3 － （交互）正在解析响应内容
    4 － （完成）响应内容解析完成，可以在客户端调用了
