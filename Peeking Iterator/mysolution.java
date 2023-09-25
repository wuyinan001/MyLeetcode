// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> it;
    Integer next=null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if(iterator.hasNext())
            next=iterator.next();
        
        it=iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        return next;
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    
        if(next==null)
            throw new NoSuchElementException();
        
        Integer ans=next;
        
        if(it.hasNext())
            next=it.next();
        else
            next=null;
        
        return ans;
        
	}
	
	@Override
	public boolean hasNext() {
	    
        return next!=null;
	}
}