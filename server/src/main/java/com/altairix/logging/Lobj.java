package com.altairix.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Data container used to manage a list of objects
 * <p>
 * @see {@link Logger#error(Lobj, String)}
 */
public class Lobj {

  public class NamedLobj {

    public final String objNm;
    public final Object obj;

    public NamedLobj(String objNm, Object obj) {
      this.objNm = objNm;
      this.obj   = obj;
    }
  }

  private final List<Object> objArrLs = new ArrayList<>();

  /**
   * Instantiate a new Lobj and initialize the contained list of objects to the supplied array
   * of objects
   */
  public Lobj(Object... objArr) {
    for (Object obj : objArr) {
      objArrLs.add(obj);
    }
  }

  /**
   * Instantiate a new Lobj and initialize the contained list of objects the individual objects
   * if the supplied object array plus the supplied objects
   */
  public Lobj(Object[] objArr, Object... objs) {
    for (Object obj : objArr) {
      objArrLs.add(obj);
    }

    add(objs);
  }

  /**
   * Instantiate a new Lobj and initialize the contained list of objects to the supplied named
   * object
   */
  public Lobj(String objNm, Object obj) {
    objArrLs.add(new NamedLobj(objNm, obj));
  }

  /**
   * Add the supplied objects to the list of objects in this Lobj
   */
  public Lobj add(Object... objArr) {
    for (Object obj : objArr) {
      objArrLs.add(obj);
    }
    return this;
  }

  /**
   * Add the supplied objects to the list of objects in this Lobj
   */
  public Lobj add(Object[] objArr, Object... objs) {
    for (Object obj : objArr) {
      objArrLs.add(obj);
    }

    return add(objs);
  }

  /**
   * Add the supplied named object to the list of objects in this Lobj
   */
  public Lobj add(String objNm, Object obj) {
    objArrLs.add(new NamedLobj(objNm, obj));
    return this;
  }

  /**
   * Add an single object which is an array of objects
   * <p>
   * This method may be used to overcome the ambiguity of providing an array of objects to
   * the related varargs method {@link #add(Object...)}. The related method would not know if the
   * caller intended to pass a list of individual objects or a single object which is an array of
   * objects.
   */
  public Lobj addArray(Object[] objArr) {
    objArrLs.add(objArr);
    return this;
  }

  /**
   * Returns a copy of this Lobj with the supplied array of objects appended to the end of the
   * object list of the new Lobj
   */
  public Lobj copy(Object... objArr) {
    Lobj newLobj = new Lobj(objArrLs);
    for (Object obj : objArr) {
      newLobj.add(obj);
    }
    return newLobj;
  }

  /**
   * Returns a copy of this Lobj with the supplied named object appended to the end of the
   * object list of the new Lobj
   */
  public Lobj copy(String objNm, Object obj) {
    Lobj newLobj = new Lobj(objArrLs);
    newLobj.add(new NamedLobj(objNm, obj));
    return newLobj;
  }

  /**
   * Returns the internal list of objects being tracked by this Lobj
   * @return
   */
  public Object[] toArray() {
    return toArrayList().toArray();
  }

  private List<Object> toArrayList() {

    List<Object> finalObjectArrLs = new ArrayList<>();

    for (Object obj : objArrLs) {
      if (obj instanceof Lobj) {
        // Check that this object is not in the list of objects
        // If it is in the list, there will be infinite recursion
        if (obj != this) {
          finalObjectArrLs.addAll(((Lobj) obj).toArrayList());
        }
      }
      else {
        finalObjectArrLs.add(obj);
      }
    }

    return finalObjectArrLs;
  }
}
