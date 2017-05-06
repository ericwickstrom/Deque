import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

/*
 * Deque implementation, using a linked list
 * Deque is a double ended queue, supports insertion
 * and removal from both front and back of que. 
 */
public class Deque<T> implements Iterable<T> {
		/*
		 * Item is used for linked list.
		 * Content is stored in item, along with
		 * pointers to next and previous Items.
		 */
		private class Item {
			public Item next = null;
			public Item prev = null;
			public T item;
			
			public Item(T t){
				item = t;
			}
		}
		
		private class ItemIterator<T> implements Iterator<T>{
			private Item current;
			
			public ItemIterator(){
				current = mFirst;
			}
			
			@Override
			public boolean hasNext() {
				return current.next != null;
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				// TODO Auto-generated method stub
				Item item = current;
				current = current.next;
				return (T) item.item;
			}
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
		}
		
		private int mSize;
		private Item mFirst = null;
		private Item mLast = null;
		
		public Deque(){
			mSize = 0;
		}
		
	   public boolean isEmpty(){
		   return mSize == 0;
	   }
	   
	   public int size(){
		   return mSize;
	   }
	   
	   public void addFirst(T t) throws NullPointerException{
		   if(t == null){
			   throw new NullPointerException();
		   }
		   
		   Item item = new Item(t);
		   item.next = mFirst;
		   mFirst = item;
		   if(mSize == 0){
			   mLast = mFirst;
		   }
		   mSize++;
	   }
	   
	   public void addLast(T t){
		   
		   Item item = new Item(t);
		   if(mSize == 0){
			   mFirst = item;
			   mLast = item;
		   } else {
			   item.prev = mLast;
			   mLast = item;
		   }
		   mSize++;
	   }
	   public T removeFirst() throws NoSuchElementException{
		   // remove and return the item from the front
		   if(mSize == 0){
			   throw new NoSuchElementException();
		   }
		   mSize--;
		   Item item = mFirst;
		   mFirst = item.next;
		   return item.item;
	   }
	   public T removeLast() throws NoSuchElementException{
		   if(mSize == 0){
			   throw new NoSuchElementException();
		   }
		   mSize--;
		   Item item = mLast;
		   mLast = item.prev;
		   return item.item;
	   }
	   
	   public Iterator<T> iterator(){
		   // return an iterator over items in order from front to end
		   return new ItemIterator();
	   }
}
