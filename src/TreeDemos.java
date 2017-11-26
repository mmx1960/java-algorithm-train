/**
 * 树-数据结构集合
 * BTree 2017-11-26
 * @author zhangzc
 */
public class TreeDemos {

    static class BST<T extends Comparable<T>>{

        private Node<T> root;

        /**
         * 增
         * @param value 插入值
         * @return 增加的节点
         */
        public Node<T> insert(T value){
            //第一次插入时设置为根节点
            if (root == null){
                Node<T> tmp = new Node<>();
                tmp.value = value;
                root = tmp;
                return root;
            }
            //设置一个当前索引
            Node<T> curr = root;
            Node<T> parent = null;
            Node<T> node = new Node<>();
            node.value = value;
            while (curr != null){
                parent = curr;
                if (curr.value.compareTo(value)<0){
                    curr = curr.right;
                }else {
                    curr = curr.left;
                }
            }

            if (parent.value.compareTo(value)<0){
                parent.right = node;
            }else {
                parent.left = node;
            }

            return node;
        }

        /**
         * 查
         * @param value 查找的值
         * @return 查找到的节点
         */
        public Node<T> get(T value) {
            Node<T> curr = this.root;
            Node<T> ret = null;
            while (curr != null){
                if (curr.value.compareTo(value)<0){
                    curr = curr.right;
                }else if (curr.value.compareTo(value)>0){

                    curr = curr.left;

                }else {
                    ret = curr;
                    break;
                }
            }
            return ret;

        }

        //暂时不写修改

        /**
         * 删
         * @param value 删除值
         * @return 删除的节点
         */
        public Node<T> delete(T value) {
            Node<T> tmp = new Node<>();
            tmp.value = value;
            Node<T> curr = root;
            Node<T> parent = null;

            while (curr != null){

                if (curr.value.equals(value)){

                    //判断左边节点
                    if (curr.left == null && curr.right == null){
                        //叶子节点直接删除
                        //如果是根节点
                        if (curr == root){
                            root = null;
                            break;
                        }
                        //一般节点
                        if (parent.value.compareTo(value)<0){
                            parent.right = null;
                        }else {
                            parent.left = null;
                        }

                    }
                    else if(curr.right == null){
                        //如果没有右子节点
                        //如果是根节点
                        if (curr == root){
                            root = curr.left;
                            break;
                        }
                        //一般节点
                        if (parent.value.compareTo(value)<0){
                            parent.right = curr.left;
                        }else {
                            parent.left = curr.left;
                        }

                    }else {
                        //以右节点为根中序遍历，找到后续节点
                        middleNext(curr.right,curr);
                        //如果是根节点
                        if (curr == root){
                            root = curr.right;
                            break;
                        }

                    }
                    break;

                }
                parent = curr;
                if (curr.value.compareTo(value)<0){
                    curr = curr.right;
                }else {

                    curr = curr.left;
                }
            }

            return tmp;

        }
        private void middleNext(Node<T> node,Node<T> curr){
            if (node.left == null){
                node.left = curr.left;
                if (curr.right != node){
                    node.right = curr.right;
                }
                return;
            }

            middleNext(node.left,curr);


        }

        class Node<T>{

            T value;
            Node<T> left;
            Node<T> right;

        }


    }

    public static void main(String[] args) {
        BST<Integer> bstTree = new BST<>();
        bstTree.insert(3);
        bstTree.insert(2);
        bstTree.insert(5);
        bstTree.insert(6);
        bstTree.insert(9);
        bstTree.delete(9);
        System.out.println();

    }




}