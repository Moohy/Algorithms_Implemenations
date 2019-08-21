import java.io.PrintWriter;
//import java.lang.reflect.Array;
//import java.util.Arrays;


/**
 * Sequential Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class SequentialRepresentation<T> implements BSPTree<T> {

    /**
     * Constructs empty graph.
     */
	
	private int LENGTH = 50;
	private T[] tree = (T[])new Object[LENGTH];
	private int counter = -1;
	private int backCounter = 0;
	
    public SequentialRepresentation() {

    }

    @Override
    public void setRootNode(T nodeLabel) {
    	if(counter > 0) return;
        tree[0] = nodeLabel;
        counter = 0;
    }

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
    	
    	Comparable<T> temp = (Comparable<T>)srcLabel;
    	int parentIndex;
    	
        if(counter+2 >= (LENGTH/2)+3)
        	expandArray();
        
        if(counter < 0) {
        	setRootNode(srcLabel);
        	parentIndex = 0;
	        this.tree[parentIndex*2+1] = leftChild;
	        counter++;
	        this.tree[parentIndex*2+2] = rightChild;	
	        counter++;
        } else {

        	if(findNode(srcLabel)) {
        		
            	for(int i = 0; i < LENGTH; i++) {
            		if(tree[i] != null && srcLabel.equals(tree[i])) {
            			if(tree[i*2+1] == null && tree[i*2+2] == null) {
	            	        tree[i*2+1] = leftChild;
	            	        counter++;
	            	        tree[i*2+2] = rightChild;	
	            	        counter++;
	            	        break;
            			}
            		}
            	}
        	} else 
        		return;
        }
        
    }
    
    public void expandArray() {
    	T[] newTree = (T[])new Object[LENGTH*2];
    	System.arraycopy(tree, 0, newTree, 0, LENGTH);
    	LENGTH*=2;
    	tree = newTree;
    }

    @Override
    public boolean findNode(T nodeLabel) {
    	String temp = nodeLabel.toString();
    	for(int i = 0; i < LENGTH; i++) {
    		if(tree[i] != null && temp.compareTo(tree[i].toString()) == 0) {
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public String findParent(T nodeLabel) {
    	StringBuilder label = new StringBuilder();
    	label.append(nodeLabel.toString()+" ");
    	Comparable<T> temp = (Comparable<T>)nodeLabel;
    	if (temp.compareTo(tree[0]) == 0) {
    		label.append("is root node.");
    		return label.toString();
    	}
    	for(int i = 0; i < LENGTH; i++) {
    		if(tree[i] != null && temp.compareTo(tree[i]) == 0) {
    			if(i%2==0)
    				label.append(tree[(i/2)-1].toString());
    			else if (i%2==1)
    				label.append(tree[(i/2)].toString());
    			else
    				label.append(tree[0].toString());
    			return label.toString();
    		}
    	}
    	return label.toString();
    }

    @Override
    public String findChildren(T nodeLabel) {
    	StringBuilder label = new StringBuilder();
    	label.append(nodeLabel.toString()+" ");
    	Comparable<T> temp = (Comparable<T>)nodeLabel;
    	for(int i = 0; i < LENGTH; i++) {
    		if(tree[i] != null && temp.compareTo(tree[i]) == 0) {
				label.append(tree[(i*2)+1].toString()+" ");
				label.append(tree[(i*2)+2].toString());
    			return label.toString();
    		}
    	}
    	return label.toString();
    }

    
    public void push (T e, T[] arr) {
        if(backCounter > LENGTH)
        	expandArray();
       arr[backCounter] = e;
       backCounter++;
    }

    @Override
    public void printInPreorder(PrintWriter writer) {
    	T[] tempArr = (T[])new Object[counter+1];
    	preorder (0, tempArr);
    	for(int i = 0; i <= counter; i++) {
//    		if(tempArr[i]!=null)
    			writer.print(tempArr[i]+ " ");
    	}
    	writer.println();
    	backCounter = 0;
    }
    
    private void preorder (int i, T[] tempArr) {
	   if (i < LENGTH ) {
	      if (tree[i] != null) {
	    	  push(tree[i], tempArr);
	    	  preorder ((i*2)+1,tempArr);
	    	  preorder ((i*2)+2, tempArr);
	      }
	   }
    }

    @Override
    public void printInInorder(PrintWriter writer) {
    	T[] tempArr = (T[])new Object[counter+1];
    	inorder (0, tempArr);
    	for(int i = 0; i <= counter; i++) {
//    		if(tempArr[i]!=null)
    			writer.print(tempArr[i]+ " ");
    	}
    	writer.println();
    	backCounter = 0;
    }
    
    private void inorder (int i, T[] tempArr) {
	   if (i < LENGTH) {
	      if (tree[i] != null) {
	         inorder ((i*2)+1, tempArr);
	         push(tree[i], tempArr);
	         inorder ((i*2)+2, tempArr);
	      }
	   }
	}  

    @Override
    public void printInPostorder(PrintWriter writer) {
    	T[] tempArr = (T[])new Object[counter+1];
    	postorder (0, tempArr);
    	for(int i = 0; i <= counter; i++) {
//    		if(tempArr[i]!=null)
    			writer.print(tempArr[i]+ " ");
    	}
    	writer.println();
    	backCounter = 0;
    }
    
    private void postorder (int i, T[] tempArr) {
	   if (i < LENGTH) {
		  if (tree[i] != null) {
			  postorder ((i*2)+1, tempArr);
			  postorder ((i*2)+2, tempArr);
			  push(tree[i], tempArr);
		  }
	   }
    }

}