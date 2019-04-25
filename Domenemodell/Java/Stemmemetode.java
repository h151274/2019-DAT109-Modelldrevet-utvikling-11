/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;
import java.sql.Date;

// line 52 "model.ump"
// line 114 "model.ump"
public class Stemmemetode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stemmemetode Associations
  private List<Arrengement> arrengements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stemmemetode()
  {
    arrengements = new ArrayList<Arrengement>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Arrengement getArrengement(int index)
  {
    Arrengement aArrengement = arrengements.get(index);
    return aArrengement;
  }

  public List<Arrengement> getArrengements()
  {
    List<Arrengement> newArrengements = Collections.unmodifiableList(arrengements);
    return newArrengements;
  }

  public int numberOfArrengements()
  {
    int number = arrengements.size();
    return number;
  }

  public boolean hasArrengements()
  {
    boolean has = arrengements.size() > 0;
    return has;
  }

  public int indexOfArrengement(Arrengement aArrengement)
  {
    int index = arrengements.indexOf(aArrengement);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArrengements()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Arrengement addArrengement(String aNavn, String aBeskrivelse, Date aUtgaar)
  {
    return new Arrengement(aNavn, aBeskrivelse, aUtgaar, this);
  }

  public boolean addArrengement(Arrengement aArrengement)
  {
    boolean wasAdded = false;
    if (arrengements.contains(aArrengement)) { return false; }
    Stemmemetode existingStemmemetode = aArrengement.getStemmemetode();
    boolean isNewStemmemetode = existingStemmemetode != null && !this.equals(existingStemmemetode);
    if (isNewStemmemetode)
    {
      aArrengement.setStemmemetode(this);
    }
    else
    {
      arrengements.add(aArrengement);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArrengement(Arrengement aArrengement)
  {
    boolean wasRemoved = false;
    //Unable to remove aArrengement, as it must always have a stemmemetode
    if (!this.equals(aArrengement.getStemmemetode()))
    {
      arrengements.remove(aArrengement);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArrengementAt(Arrengement aArrengement, int index)
  {  
    boolean wasAdded = false;
    if(addArrengement(aArrengement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrengements()) { index = numberOfArrengements() - 1; }
      arrengements.remove(aArrengement);
      arrengements.add(index, aArrengement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArrengementAt(Arrengement aArrengement, int index)
  {
    boolean wasAdded = false;
    if(arrengements.contains(aArrengement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrengements()) { index = numberOfArrengements() - 1; }
      arrengements.remove(aArrengement);
      arrengements.add(index, aArrengement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArrengementAt(aArrengement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=arrengements.size(); i > 0; i--)
    {
      Arrengement aArrengement = arrengements.get(i - 1);
      aArrengement.delete();
    }
  }

}