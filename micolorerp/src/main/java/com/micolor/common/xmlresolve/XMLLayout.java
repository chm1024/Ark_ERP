package com.micolor.common.xmlresolve;

/**XML布局类
 * Created by Administrator on 2016/11/12.
 */
public class XMLLayout {
    public XMLLayout(){}
    /**
     * @param root 根节点名称
     * @param head 头部节点名称
     * @param item 子节点名称
     */
    public XMLLayout(String root,String head,String item){
        this.root=root;
        this.head=head;
        this.item=item;
    }

    /**
     * @param root 根节点名称
     * @param head 头部节点名称
     * @param item 子节点名称
     * @param childName 子节点内节点名称
     */
    public XMLLayout(String root,String head,String item,String[] childName){
        this.root=root;
        this.head=head;
        this.item=item;
        this.childName=childName;
    }

    /**
     * @param root 根节点名称
     * @param head 头部节点名称
     * @param item 子节点名称
     * @param notShowNode 头部节点排除项(比如ID，同步标志等节点)
     * @param childName 子节点内节点名称
     */
    public XMLLayout(String root,String head,String item,String[] notShowNode,String[] childName){
        this.root=root;
        this.head=head;
        this.item=item;
        this.notShowNode=notShowNode;
        this.childName=childName;
    }
    /**
     * 根节点
     * */
    private String root;
    /**
     * 头部
     * */
    private String head;
    /**
     * 内容
     * */
    private String item;
    /**
     * 子节点名称
     * */
    private String[] childName;
    /**
     * 头部节点排除项名称
     * */
    private String[] notShowNode;


    public String[] getChildName() {
        return childName;
    }

    public void setChildName(String[] childName) {
        this.childName = childName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String[] getNotShowNode() {
        return notShowNode;
    }

    public void setNotShowNode(String[] notShowNode) {
        this.notShowNode = notShowNode;
    }
}
