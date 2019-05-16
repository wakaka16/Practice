package treeNode;


/**
 * @author wangxiaolong
 * @date 2019/3/8 16:35
 */
public class Tree{

  private Node root;
  private int size;

  public boolean put(int value){
    if(root==null){
      root = new Node(value,null,null,null);
      this.size++;
      return true;
    }
    return put(value,root);
  }


  private boolean put(int value,Node node){
    int v = node.getValue();
    Node left,right,isRoot;
    if(v>=value){
      if((left=node.getLeft())!=null){
        if(left.getLeft()==null&&left.getRight()==null){
          this.size++;
          left.setLeft(new Node(value,null,node,null));
          left.setRight(node);
          isRoot =node.getParent();
          left.setParent(isRoot);
          if(isRoot==null){
            this.root=left;
          }
          node.setParent(left);
          return true;
        }
        put(value,left);
      }else{
        this.size++;
        node.setLeft(new Node(value,null,node,null));
      }
    }else{
      if((right=node.getRight())!=null){
        if(right.getLeft()==null&&right.getRight()==null){
          this.size++;
          right.setLeft(node);
          right.setRight(new Node(value,null,node,null));
          isRoot =node.getParent();
          right.setParent(isRoot);
          if(isRoot==null){
            this.root=right;
          }
          node.setParent(right);
          return true;
        }
        put(value,right);
      }else{
        this.size++;
        node.setRight(new Node(value,null,node,null));
      }
    }
    return true;
  }


  public int getSize() {
    return size;
  }
}
 class Node{
    private int value;
    private Node left;
    private Node right;
    private Node parent;

    Node(int value,Node left,Node parent,Node right){
      this.value=value;
      this.left = left;
      this.parent = parent;
      this.right = right;
    }

   public int getValue() {
     return value;
   }

   public void setValue(int value) {
     this.value = value;
   }

   public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

   public static void main(String[] args) {
     Tree tree = new Tree();
     tree.put(1);
     tree.put(2);
     System.out.println(tree.getSize());
   }

}
