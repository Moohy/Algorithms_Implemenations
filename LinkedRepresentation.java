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
		BTnode<T> root;
		BTnode<T> l;
		BTnode<T> r;
		String label;
		
		public BTnode() {
			root =null;
			root.l = null;
			root.r = null;
		}
		
		public BTnode(T node) {
			root = (BTnode<T>) node;
			root.l = null;
			root.r = null;
		}
		
		public BTnode getParent(T node) {
			return null;
		}
		
		public String getLabel() {
			return this.label;
		}
		
		public void setValue(String label) {
			root.label = label;
		}
		
		public void setLChild(T node) {
			root.l = (BTnode<T>)node;
		}
		
		public void setRChild(T node) {
			root.r = (BTnode<T>)node;
		}
		
	    public boolean hasRoot(BTnode node) {
	    	if(node.root != null) {
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean hasRChild(BTnode node) {
	    	if(node.r != null) {
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean hasLChild(BTnode node) {
	    	if(node.l != null) {
	    		return true;
	    	}
	    	return false;
	    }
	}
	
	private BTnode node;
    /**
     * Constructs empty tree.
     */
    public LinkedRepresentation() {
        // Implement me!
    	
    } // end of LinkedRepresentation()
    
    public LinkedRepresentation(String label) {
        // Implement me!
    	
    }

    @Override
    public void setRootNode(T nodeLabel) {
        // Implement me!
    	node = new BTnode<T>(nodeLabel);
    	
    			
    } // end of setRootNode()

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
        // Implement me!
    	
    } // end of splitNode

    @Override
    public boolean findNode(T nodeLabel) {
        // Implement me!
        return false;
    } // end of findNode

    @Override
    public String findParent(T nodeLabel) {
        // Implement me!
        return null;
    } // end of findParent

    @Override
    public String findChildren(T nodeLabel) {
        // Implement me!

        return null;
    } // end of findParent

    @Override
    public void printInPreorder(PrintWriter writer) {
        // Implement me!
    } // end of printInPreorder

    @Override
    public void printInInorder(PrintWriter writer) {
        // Implement me!
    } // end of printInInorder

    @Override
    public void printInPostorder(PrintWriter writer) {
        // Implement me!
    } // end of printInPostorder
    


} // end of class LinkedRepresentation
