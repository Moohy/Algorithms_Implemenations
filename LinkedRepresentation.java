import java.io.PrintWriter;


/**
 * Linked Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016. 
 * @author Yongli Ren, 2019.
 */

public class LinkedRepresentation<T> implements BSPTree<T> {
	
	public class BTnode<T> {
		T value;
		BTnode<T> l;
		BTnode<T> r;

		public BTnode(T value) {
			this.value = value;
			l = null;
			r = null;
		}
	}
	
    /**
     * Constructs empty tree.
     */
	public BTnode root;
	
    public LinkedRepresentation() {  
    	root = null;
    }
    
    public LinkedRepresentation(String label) {
        setRootNode((T)label);
    }

    @Override
    public void setRootNode(T nodeLabel) {      
    	root = new BTnode(nodeLabel);  			
    }

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
    	
    	if(root == null) {
    		setRootNode(srcLabel);
    		root.l = new BTnode(leftChild);
    		root.r = new BTnode(rightChild);
    	} else if (findNode(srcLabel)){
    		BTnode t = getNode(srcLabel);
    		if(t != null) {
	            t.l = new BTnode(leftChild);
	            t.r = new BTnode(rightChild);
    		}
        }
    	
    }

    @Override
    public boolean findNode(T nodeLabel) {
    	return findNode(root, nodeLabel);
    }
    
    private boolean findNode(BTnode node, T nodeLabel) {
    	if (node == null)  
            return false;  
      
        if (node.value.equals(nodeLabel))  
            return true;  
      
        boolean lTree = findNode(node.l, nodeLabel);        
        boolean rTree = findNode(node.r, nodeLabel);  
      
        return lTree || rTree;  
    }
    
    public BTnode getNode(T nodeLabel) {
    	return getNode(root, nodeLabel);
    }
    
    private BTnode getNode(BTnode node, T nodeLabel) {      
        if(node != null){
            if(node.value.equals(nodeLabel)){
               return node;
            } else {
                BTnode foundNode = getNode(node.l, nodeLabel);
                if(foundNode == null) {
                    foundNode = getNode(node.r, nodeLabel);
                }
                return foundNode;
             }
        } else {
            return null;
        }
    }

    @Override
    public String findParent(T nodeLabel) {
    	StringBuilder s = new StringBuilder();
    	s.append(nodeLabel + " " + findParent(root, nodeLabel));
        return s.toString();
    }
    
    private String findParent(BTnode node, T nodeLabel) {
        if(node != null){
            if((node.l != null && node.l.value.equals(nodeLabel)) || (node.r != null && node.r.value.equals(nodeLabel))){
               return (String) node.value;
            } else {
                String label = findParent(node.l, nodeLabel);
                if(label == null) {
                	label = findParent(node.r, nodeLabel);
                }
                return label;
             }
        }
		return null;
    }

    @Override
    public String findChildren(T nodeLabel) {
    	BTnode t = getNode(nodeLabel);
    	
    	StringBuilder s = new StringBuilder();
    	s.append(nodeLabel + " ");
    	if(t != null) {
    		if(t.l != null)
				s.append(t.l.value + " ");
			if(t.r != null)
				s.append(t.r.value + " ");
			return s.toString();
    	}

        return null;
    }

    @Override
    public void printInPreorder(PrintWriter writer) {
    	preorder(root, writer);
    }
    
    private void preorder(BTnode node, PrintWriter writer) {
        if (node == null) 
            return; 
        writer.print(node.value + " ");
        
 
        if(node.l != null)
        	preorder(node.l, writer); 
  
        if(node.r != null)
        	preorder(node.r, writer); 
    }

    @Override
    public void printInInorder(PrintWriter writer) {
    	inorder(root, writer);
    }
    
    private void inorder(BTnode node, PrintWriter writer) {
        if (node == null) 
            return; 
 
        if(node.l != null)
        	inorder(node.l, writer); 
        
        writer.print(node.value + " ");
  
        if(node.r != null)
        	inorder(node.r, writer); 
    }

    @Override
    public void printInPostorder(PrintWriter writer) {
    	postorder(root, writer);
    }
    
    private void postorder(BTnode node, PrintWriter writer) {
        if (node == null) 
            return; 
 
        if(node.l != null)
        	postorder(node.l, writer); 
  
        if(node.r != null)
        	postorder(node.r, writer); 
        
        writer.print(node.value + " ");
    }
}
