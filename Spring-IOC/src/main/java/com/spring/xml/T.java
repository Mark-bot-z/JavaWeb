package com.spring.xml;

import java.util.List;

public class T {
    private List<Gather.Node> nodeList;

    public List<Gather.Node> getNodeList() {
        return nodeList;
    }

    @Override
    public String toString() {
        return "T{" +
               "nodeList=" + nodeList +
               '}';
    }

    public void setNodeList(List<Gather.Node> nodeList) {
        this.nodeList = nodeList;
    }
}
