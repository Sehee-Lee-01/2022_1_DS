class DLink<E> {
    E item;
    DLink<E> next;
    DLink<E> prev;
    // 생성자
    DLink(E item, DLink<E> prev, DLink<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
    // method
    DLink<E> next() {return next;}
    DLink<E> setNext(DLink<E> next) {return this.next = next;}
    DLink<E> prev() {return prev;}
    DLink<E> setPrev(DLink<E> prev) {return this.prev = prev;}
    E item() {return item;}
    E setItem(E item) {return this.item = item;}
    
}