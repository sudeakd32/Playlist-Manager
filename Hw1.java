

/*
My design supports adding, removing, moving, and reversing songs while maintaining proper pointer updates.
In doubly linked list class playNext() and playPrevious() methods plays current song (which is the first song in the beginning)
and changes current song. You can not remove current song. There is a removeSongForMoveSongMethod() method extra for
using in the moveSong() method. It removes the selected song even if it is current song.
*/
class Node {
    private Song song;
    private Node next;
    private Node prev;

    public Node(Song song)
    {
        this.song = song;
        this.next = null;
    }

    public Song getSong() {
        return song;
    }
    public Node getPrev() {
        return prev;
    }
    public Node getNext() {
        return next;
    }

    public void setSong(Song song) {
        this.song = song;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }

}

class Song {
    String title;
    String artist;
    int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Duration: " + duration;
    }
}

class SinglyLinkedList {
    Node head;
    Node tail;

    public void addSong(String title, String artist, int duration) {

        Song newSong = new Song(title, artist, duration);
        Node newNode = new Node(newSong);

        //If we are trying to add first song to the playlist
        if (head == null) {
            head = newNode;
            tail = head;
            System.out.println("The first song successfully added to the list.");
            return;
        }

        //Inserting new node to the end of the playlist
        tail.setNext(newNode);
        tail = newNode;
        System.out.println("Song successfully added to the list.");

    }

    public void removeSong(String title) {

        Node temp = head;
        Node prev = head;
        boolean isFound = false;

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to remove!");
            return;
        }

        //We are trying to find song that will be deleted
        while (temp != null) {
            if (temp.getSong().title.equalsIgnoreCase(title)) {
                isFound = true;
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }

        if (isFound) {
            //If there is one song in the playlist to remove
            if(head.getNext() == null) {
                head = null;
                System.out.println("Song successfully removed. The playlist is empty.");
                return;
            }
            prev.setNext(temp.getNext());
            temp = null;
            System.out.println("Song successfully removed.");
        }
        else {
            System.out.println("The song you are trying to remove is not found!");
        }

    }

    public void searchSong(String title) {

        Node temp = head;
        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to search!");
            return;
        }

        //Traversing in singly linked list
        while (temp != null) {
            if (temp.getSong().title.equalsIgnoreCase(title)) {
                System.out.println("Song found!");
                System.out.println(temp.getSong());
                return;
            }
            temp = temp.getNext();
        }

        System.out.println("The song you are trying to search not found!");
    }

    public void reversePlaylist() {

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to reverse!");
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        //Update tail to the current head
        tail = head;

        //Traverse the list and reverse pointers
        while (current != null) {
            next = current.getNext();   // Store the next node
            current.setNext(prev);      // Reverse pointer
            prev = current;             // Move prev forward
            current = next;             // Move current forward
        }

        //Update head to the last node processed
        head = prev;

    }

    public void displayPlaylist() {

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to show!");
            return;
        }

        Node temp = head;
        System.out.println("\nPlaylist: ");
        int index = 1;
        while (temp != null) {
            System.out.println("Song " + index++ + " --- " + temp.getSong());
            temp = temp.getNext();
        }

    }
}
class DoublyLinkedList{
    Node head;
    Node tail;
    Node currentSong;
    int index = 0;

    public void addSong(String title, String artist, int duration) {

        Song newSong = new Song(title, artist, duration);
        Node newNode = new Node(newSong);

        //If playlist is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("The first song successfully added to the list.");
            //First song will be played in playlist
            currentSong = newNode;
            index++;
            return;
        }

        //Inserting new node at the end of the playlist
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        index++;

    }

    public void removeSong(String title) {

        Node temp = head;

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to remove!");
            return;
        }

        //We can not remove current song
        else if(title.equalsIgnoreCase(currentSong.getSong().title)){
            System.out.println("The song you are trying to remove is playing. You can not remove this song!");
            return;
        }

        // Search for the song in the list
        while (temp!=null && !temp.getSong().title.equalsIgnoreCase(title)) {
            temp = temp.getNext();
        }

        // If song not found
        if (temp == null) {
            System.out.println("The song you are trying to remove is not found!");
            return;
        }

        //If there is one song in the playlist
        if (head == tail && temp == head) {
            head = null;
            tail = null;
            System.out.println("Song successfully removed. The playlist is empty.");
            return;
        }

        //Removing the head node
        if (temp == head) {
            head = head.getNext();
            head.setPrev(null);
            System.out.println("Song successfully removed from the start.");
            return;
        }

        //Removing the tail node
        if (temp == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
            System.out.println("Song successfully removed from the end.");
            return;
        }

        //Removing a node in the middle
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

        System.out.println("Song successfully removed from the list.");

    }

    public void removeSongForMoveSongMethod(String title){
        Node temp = head;

        // Search for the song in the list
        while (temp!=null && !temp.getSong().title.equalsIgnoreCase(title)) {
            temp = temp.getNext();
        }

        //Removing the head node
        if (temp == head) {
            head = head.getNext();
            head.setPrev(null);
            return;
        }

        //Removing the tail node
        if (temp == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
            return;
        }

        //Removing a node in the middle
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

    }

    public Song searchSong(String title) {

        Node temp = head;
        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to search!");
            return null;
        }

        while (temp != null) {
            if (temp.getSong().title.equalsIgnoreCase(title)) {
                //Returns the found song
                return temp.getSong();
            }
            temp = temp.getNext();
        }

        System.out.println("The song you are trying to search not found!");
        return null;
    }

    public void displayPlaylist() {

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to show!");
            return;
        }

        Node temp = head;
        System.out.println("\nPlaylist: ");
        int index = 1;
        while (temp != null) {
            System.out.println("Song " + index++ + " --- " + temp.getSong());
            temp = temp.getNext();
        }
    }

    public void reversePlaylist() {

        Node current = head;
        Node temp = null;

        if (head == null) {
            System.out.println("The playlist is empty. There is nothing to reverse!");
            return;
        }

        //Swap previous and next of a current node
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }

        //Update head and tail
        if (temp != null) {
            tail = head;            // The old head is now the last node
            head = temp.getPrev();  // The last node before loop ended is the new head
        }

    }

    public void playNext() {

        if(currentSong == null){
            System.out.println("The playlist is empty. There is no next song to play in the list.");
            return;
        }
        //The current song will be played and moved into the next song if it exists.
        System.out.println("The song "+currentSong.getSong().title+" is playing!");

        if(currentSong.getNext() == null){
            System.out.println("There is no next song to play in the list.");
            return;
        }
        System.out.println("Moved on to the next song.");
        currentSong = currentSong.getNext();
    }

    public void playPrevious() {

        if(currentSong == null){
            System.out.println("The playlist is empty. There is no previous song to play in the list.");
            return;
        }
        //The current song will be played and moved into the previous song if it exists.
        System.out.println("The song "+currentSong.getSong().title+" is playing!");

        if(currentSong.getPrev() == null){
            System.out.println("There is no previous song to play in the list.");
            return;
        }

        System.out.println("Moved on to the previous song.");
        currentSong = currentSong.getPrev();
    }

    public void moveSong(String title, int newPosition) {

        if(head == null) {
            System.out.println("The playlist is empty. There is nothing to move!");
            return;
        }

        if (searchSong(title) == null) {
            System.out.println("The song you are trying to move is not found!");
            return;
        }

        if(newPosition > index){
            System.out.println("You entered invalid position. There are not enough songs in the list!");
            return;
        }

        Node temp = head;
        Node newNode = null;

        //To find song to store in newNode variable
        while (temp != null) {
            if (temp.getSong().title.equalsIgnoreCase(title)) {
                newNode = temp;
                break;
            }
            temp = temp.getNext();
        }

        if (newPosition == 1 && newNode == head) {
            System.out.println("The song is already at the first position!");
            return;
        }

        //To move song at the beginning of a list
        if(newPosition == 1){
            removeSongForMoveSongMethod(title);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            System.out.println("Song successfully moved to position 1!");
            return;
        }

        //To move song at the end of the list
        if (newPosition == index) {
            removeSongForMoveSongMethod(title);
            //Using addSong() method
            addSong(newNode.getSong().title,newNode.getSong().artist,newNode.getSong().duration);
            index--; //because we don't actually add a new song
            System.out.println("Song successfully moved to position "+newPosition+"!");
            return;
        }

        int tempIndex = 1;
        Node temp1 = head;
        Node temp2 = head;

        //Setting temp1 as the node before the given position
        while (temp1 != null && tempIndex < newPosition) {
            tempIndex++;
            temp1 = temp1.getNext();
        }

        //Setting temp2 as the node after the given position
        temp2 = temp1.getNext();

        //Deleting the node and inserting it to the given position
        removeSongForMoveSongMethod(title);
        temp1.setNext(newNode);
        temp2.setPrev(newNode);
        newNode.setPrev(temp1);
        newNode.setNext(temp2);

        System.out.println("Song successfully moved to position "+newPosition+"!");

    }
}

