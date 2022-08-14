package com.spring.xml;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Gather {
    private int[] ints;
    private Node[] nodes;

    private List<String> listName;

    private Set<Integer> setAge;

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    private List<Node> nodeList;

    private Map<String,Integer> map;

    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }

    private Map<String , Node> nodeMap;

    public static class Node{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        private String name;

        @Override
        public String toString() {
            return "Node{" +
                   "name='" + name + '\'' +
                   '}';
        }
    }

    @Override
    public String toString() {
        return "Gather{" +
               "ints=" + Arrays.toString(ints) +
               ", nodes=" + Arrays.toString(nodes) +
               ", listName=" + listName +
               ", setAge=" + setAge +
               ", nodeList=" + nodeList +
               ", map=" + map +
               ", nodeMap=" + nodeMap +
               '}';
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public List<String> getListName() {
        return listName;
    }

    public void setListName(List<String> listName) {
        this.listName = listName;
    }

    public Set<Integer> getSetAge() {
        return setAge;
    }

    public void setSetAge(Set<Integer> setAge) {
        this.setAge = setAge;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
