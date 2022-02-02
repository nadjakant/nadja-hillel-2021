package HW9;

import java.util.Iterator;

public class LinkedCollection implements CustomCollection<String, LinkedCollection> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
        private String value;
        private Node next;
        private Node prev;

        public Node(String value) {
            this.value = value;
        }
    }

    @Override
    public boolean add(String str) {
        Node currentNode = new Node(str);
        // первое добавление в список
        if (head == null) {
            this.head = currentNode;
        } else {
            tail.next = currentNode;
            currentNode.prev = tail;
        }
        tail = currentNode;
        size++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }

        for (int i = 0; i < strArr.length; i++) {
            add(strArr[i]);
        }

        return true;
    }

    public String[] toArray() {
        if (head == null) {
            return null;
        }

        String[] newArray = new String[size];
        Node currentNode = head;

        newArray[0] = head.value;

        int index = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            index++;

            newArray[index] = currentNode.value;
        }
        return newArray;
    }


    @Override
    public boolean addAll(LinkedCollection strColl) {
        if (strColl == null || strColl.size() == 0) {
            return false;
        }

        this.addAll(strColl.toArray());

        return true;
    }

    @Override
    public boolean delete(int index) {
        Node nodeToDelete = getNode(index);
        if (nodeToDelete == null) {
            return false;
        }

        delete(nodeToDelete);
        return true;
    }

    @Override
    public boolean delete(String str) {
        Node nodeToDelete = getNode(str);
        if (nodeToDelete == null) {
            return false;
        }

        delete(nodeToDelete);
        return true;
    }

    private void delete(Node nodeToDelete) {
        if (head == null || nodeToDelete == null) {
            return;
        }
        if (head == tail) {
            clear();
            return;
        } else if (nodeToDelete == tail) {
            nodeToDelete.prev.next = null;
            tail = nodeToDelete.prev;
        } else if (nodeToDelete == head) {
            head = head.next;
            head.prev = null;
        } else {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
        size--;
    }

    private Node getNode(int index) {
        if (head == null || index < 0 || index >= size) {
            return null;
        }

        int currentIndex = 0;
        Node currentNode = head;
        if (currentIndex == index) {
            return currentNode;
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            currentIndex++;

            if (currentIndex == index) {
                return currentNode;
            }
        }
        return null;
    }

    private Node getNode(String str) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;
        if (currentNode.value == str) {
            return currentNode;
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;

            if (currentNode.value == str) {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        Node nodeToGet = getNode(index);
        if (nodeToGet == null) {
            return null;
        }

        return nodeToGet.value;
    }

    @Override
    public boolean contains(String str) {
        return getNode(str) != null;
    }

    @Override
    public boolean clear() {
        head = null;
        tail = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
//    не реализованно как обсуждалось
    public boolean trim() {
        return false;
    }

    @Override
    public boolean compare(LinkedCollection coll) {
        if (this.size != coll.size()) {
            return false;
        }

        return this.toString().equals(coll.toString());
    }

    @Override
    public String toString() {
        if (head == null) {
            return "<empty list>";
        }

        Node currentNode = head;
        String result = "";

        result += currentNode.value;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result += ", " + currentNode.value;
        }

        return result;
    }

    public void print() {
        System.out.println(this.toString());
    }
}
