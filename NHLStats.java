/*Node class
Defines a Node object to build a Linked List
*/
public class NHLStats<T>{
	private T data;
	private NHLStats<T> next;
    
	public NHLStats(T data, NHLStats<T> next){
		this.data = data;
		this.next = next;
	}
    
	public T getData(){
		return data;
	}
    
	public NHLStats<T> getNext(){
		return this.next;
	}
    
	public void setData(T data){
		this.data = data;
	}
    
	public void setNext(NHLStats<T> next){
		this.next = next;
	}

    /* Method for getting the player with the most goals and assists
     * Reads through each value in the linked list after this node (you should probably call this on the head node)
     * Returns -1 if it can't find any values
     * */
    public PlayerRecord get_most_goals_and_assists(NHLStats<PlayerRecord> head) {

        NHLStats<PlayerRecord> current = head;

        int max_goals_and_assists = -1;
        PlayerRecord max_node = null;

        while (current.getNext() != null) {

            PlayerRecord pr = current.getData();
            int current_goals_and_assists = pr.goals_scored + pr.assists;

            if (current_goals_and_assists > max_goals_and_assists) {
                max_goals_and_assists = current_goals_and_assists;
                max_node = pr;
            }

            current = current.getNext();

        }

        return max_node;

    }

}
