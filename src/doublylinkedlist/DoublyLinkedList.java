package doublylinkedlist;
import java.util.*;
/*
Mert Can Türkyılmaz
170101029

I added comments as much as possible

*/
public class DoublyLinkedList { 
    Node head; 
 
    class Node { 
        int data; 
        Node prev; 
        Node next; 
  
        Node(int d) { data = d; } 
    } 
    
    void add(int t) //function to add a node
    { 

        Node new_node = new Node(t); 
  
        Node last = head;

        new_node.next = null; 
  
        if (head == null) { //if head is null, our added node is head
            new_node.prev = null; 
            head = new_node; 
            return; 
        } 
  
        while (last.next != null)  // we are finding last element if head wasnt the last
            last = last.next; 
  

        last.next = new_node; //next of the last (new last :)) is our new node
 
        new_node.prev = last; 
    } 
      Node deleteNode(Node delete) //deleting the node function
    {
        if (head == null || delete == null) 
            return null;
 
        if (head == delete) //if our delete node is head node, then our head now is delete.next (second node)
            head = delete.next;
 
        if (delete.next != null)  //we are changing the prev and next so we are basically deleting the node
            delete.next.prev = delete.prev;
 
        if (delete.prev != null)
            delete.prev.next = delete.next;
 
        delete = null;
 
        return head;
    }
  void remove(int index)
    {
      
        if (head == null || index <= 0) // if node is empty or our input makes no sense, we return
            return;
 
        Node current = head; //we are starting to head for searching
        int i;
 
        for (i = 1; current != null && i < index; i++)
        {
            current = current.next; //we are going to our index step by step with a for loop
        }
       
        if (current == null) //if our index was null, we return
            return;
 
        deleteNode(current); //if not, we delete it with my other function
    }
  void clear() //function for clear the node
    {

        if (head == null)// if node is empty we return
            return;
 
        Node current = head;
        int i;

        for (i = 0; current != null; i++)
        {
            deleteNode(current);    // İt's like remove function, we are going step by step but now, we delete every single one.
            current = current.next;
        }
    }
   int size() //function for getting size of node
    { 
        int res = 0;    //our counter
        Node h = head;  //We are starting from head
        while (h != null)   //The while loop will increment our counter until it reaches the end of the node.
        { 
                res++; //increase
                h = h.next; //Next node
        } 
        return res; //returns our counter
    }        
  
    Node find(int index){ //A function which we can use to find index'th Node. I wrote it to use in add function.
        int i;
        Node h= head.next;
        for (i = 1; i <index; i++)
        {
           h = h.next;
        }
        return h;
    }
    int get(int index){ //A function which we can use to find index'th element of Node.
        int i;
        Node h= head.next; //We are starting from head
        for (i = 1; i <index; i++)
        {
           h = h.next; //The for loop will increment our counter until it reaches te index'th element
        }
        return h.data; //We return it
    }
    
      public void add(int index, int t) //function for adding elements to node after index'th element
    { 
        Node prev_Node = find(index); //we find the node on index'th element with my function
   
        if (prev_Node == null) { //prew_node cannot be null
            System.out.println("The given previous node cannot be NULL "); 
            return; 
        } 
  
        Node new_node = new Node(t); //we define new node
  
        new_node.next = prev_Node.next; //we are adding our new node
 
        prev_Node.next = new_node; 
  
        new_node.prev = prev_Node; 
  
        if (new_node.next != null) //new node might be last, we check it.
            new_node.next.prev = new_node; 
    } 
    public void print(Node node) //function for printing the List
    { 
        Node last = null; 
        System.out.println("DoublyLinkedList is:"); 
        while (node != null) { 
            System.out.print(node.data + " "); 
            last = node; 
            node = node.next; 
        } 
    } 
  boolean contains(int a) //checks if our list have the element or not
    { 
        Node h = head; //We are starting from head
        while (h != null)  
        {                       //The while loop checks Nodes until it reaches the element which we are looking for.
              if (h.data==(a)){
                  return true;  //if loop can reach it, return true
              }
                h = h.next; 
        } 
        return false; // if while loop cant reach the element, that means we dont have it, returns false
    } 
   boolean isEmpty(){ //checks if list empty or not
        return (head == null);
   }
   void addAll(List<Integer> list){ //adds a whole list
        for (int i:list){
            add(list.get(i));
        }
    }

    public static void main(String[] args) 
    { 
        DoublyLinkedList dll = new DoublyLinkedList(); 
  
        dll.add(6); 
        dll.add(4); 
        dll.add(6);
        dll.add(8);
        dll.add(1, 8); 
        dll.remove(2);
        System.out.println(" "); 
        dll.print(dll.head); 
        System.out.println(' ');
        System.out.println("Size of List is: "+ dll.size());
        System.out.println("List contains 4: "+dll.contains(6));
        System.out.println("List contains 20: "+dll.contains(20));
        //dll.clear();  //Delete the first "//" to try clear function.
        System.out.println("is List empty :" + dll.isEmpty());
        System.out.println("2. element of List :" + dll.get(2));
        
    } 
} 