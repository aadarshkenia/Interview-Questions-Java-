import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class _212{
	public static void main(String args[]){
		//char[][] matrix = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}; 
		//String[] words = {"oath","pea","eat","rain"};
		char[][] matrix = {{'a', 'b'}, {'a', 'a'}};
		String[] words = {"aaab", "aaa"};
		List<String> ans = findWords(matrix, words);
		System.out.println(ans);
	}

	public static List<String> findWords(char[][] board, String[] words) {
     	List<String> ans = new ArrayList();
     	HashSet<String> foundWords = new HashSet();

     	Trie trie = new Trie();
     	for(String word : words)
     		trie.addWord(word);
     	// System.out.println(trie.search(trie.getRoot(), "aaab"));
    	int nr = board.length;
    	int nc = nr > 0 ? board[0].length : 0;
    	TrieNode root = trie.getRoot();
    	boolean vis[][] = new boolean[nr][nc];

    	for(int i=0; i < nr; i++)
    		for(int j=0; j < nc; j++){
    			if(root.children.containsKey(board[i][j])){
    				// System.out.println("Here: i="+i+" j="+j);
    				findWordsHelper(ans, new StringBuilder(), board, i, j, root.children.get(board[i][j]), vis, foundWords);
    			}
    		}

    	return ans;
    }


    public static boolean findWordsHelper(List<String> ans, StringBuilder parentWord, char[][] board, int r, int c, TrieNode node, boolean[][] vis, HashSet<String> foundWords){
    	vis[r][c] = true;
    	int nr = board.length;
    	int nc = nr > 0 ? board[0].length : 0;
    	boolean retval = false;
    	if(node != null){
    		if(node.val == board[r][c]){
    			parentWord.append(board[r][c]);
    			// System.out.println(parentWord.toString());
    			if(node.isLeaf){
    				String currentWord = parentWord.toString();
    				
    				if(!foundWords.contains(currentWord)){
    					ans.add(currentWord);
    					foundWords.add(currentWord);
    				}
    				retval = true;
    			}
    			
				Set childSet = node.children.keySet();
    			if(childSet.size() > 0){
    				//Bottom cell
    				if(r != nr-1){
			    		if(!vis[r+1][c] && childSet.contains(board[r+1][c])){
			    			retval |= findWordsHelper(ans, parentWord, board, r+1, c, node.children.get(board[r+1][c]), vis, foundWords);
			    		}
			    	}

			    	//Top cell
					if(r != 0){
			    		if(!vis[r-1][c] && childSet.contains(board[r-1][c])){
			    			findWordsHelper(ans, parentWord, board, r-1, c, node.children.get(board[r-1][c]), vis, foundWords);
			    		}
			    	}

			    	//Right cell
			    	if(c != nc-1){
			    		if(!vis[r][c+1] && childSet.contains(board[r][c+1])){
			    			findWordsHelper(ans, parentWord, board, r, c+1, node.children.get(board[r][c+1]), vis, foundWords);
			    		}
			    	}

			    	//Left cell
			    	if(c != 0){
			    		if(!vis[r][c-1] && childSet.contains(board[r][c-1])){
			    			findWordsHelper(ans, parentWord, board, r, c-1, node.children.get(board[r][c-1]), vis, foundWords);
			    		}
			    	}		    		
    			}
    		} 
    	}

    	vis[r][c] = false;
    	parentWord.deleteCharAt(parentWord.length()-1);
		return retval;

    }//findWordsHelper

}