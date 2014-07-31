package p;

import common.TreeLinkNode;

public class PopulationNextRightPointersInEachNodeII {
//	TreeLinkNode prev = null;
//	TreeLinkNode after = null;
//	public void connect(TreeLinkNode root){
//		if(root == null){
//			return;
//		}
//		TreeLinkNode start = root;
//	
//		while(start!=null){
//			root = start;
//			start = null;
//			while(root!=null){
//				if(prev==null){
//					root = findNextNode(root, null);
//					start = prev;
//				}
//				root = findNextNode(root, prev);
//				if(prev!=null){
//					prev.next = after;
//					prev = after;
//					after = null;
//				}
//			}
//		}
//	}
//	
//	private TreeLinkNode findNextNode(TreeLinkNode current, TreeLinkNode prevUsed){
//		TreeLinkNode ret = null;
//		if(current ==null)
//			return ret;
//		if(prevUsed!= null && prevUsed == current.left){
//			ret = current.right;
//			current = current.next;
//		}
//		while(ret == null && current!=null){
//			if(current.left!=null){
//				ret = current.left;
//				break;
//			}
//			if(current.right!=null){
//				ret = current.right;
//				break;
//			}
//			current = current.next;
//		}
//		if(prev==null){
//			prev = ret;
//		}else{
//			after = ret;
//		}
//		return current;
//	}
	
	public void connect(TreeLinkNode root) {
        if (root==null){
            return;
        }   
        
        TreeLinkNode current=root;
        TreeLinkNode nextLevelHead=null;
        TreeLinkNode nextLevelEnd=null;
        while (current!=null){
            if (current.left!=null){
                if (nextLevelHead==null){
                   nextLevelHead=current.left;
                   nextLevelEnd=nextLevelHead;
                }
                else{
                    nextLevelEnd.next=current.left;
                    nextLevelEnd=nextLevelEnd.next;
                
                }
            }
            
            if (current.right!=null){
                if (nextLevelHead==null){
                   nextLevelHead=current.right;
                   nextLevelEnd=nextLevelHead;
                }
                else{
                    nextLevelEnd.next=current.right;
                    nextLevelEnd=nextLevelEnd.next;
                
                }
            }
            
            current=current.next;
            if (current==null){
                
                current=nextLevelHead;
                nextLevelHead=null;
                nextLevelEnd=null;
            }
        }
   }
	
	public static void main(String args[]){
		TreeLinkNode node = new TreeLinkNode(1);
		node.right = new TreeLinkNode(2);
		new PopulationNextRightPointersInEachNodeII().connect(new TreeLinkNode(0));
	}
}
