/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 38 "model.ump"
// line 102 "model.ump"
public class Brukegruppe
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Brukegruppe Attributes
  private String gruppenavn;

  //Brukegruppe Associations
  private List<Bruker> brukers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Brukegruppe(String aGruppenavn)
  {
    gruppenavn = aGruppenavn;
    brukers = new ArrayList<Bruker>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setGruppenavn(String aGruppenavn)
  {
    boolean wasSet = false;
    gruppenavn = aGruppenavn;
    wasSet = true;
    return wasSet;
  }

  public String getGruppenavn()
  {
    return gruppenavn;
  }
  /* Code from template association_GetMany */
  public Bruker getBruker(int index)
  {
    Bruker aBruker = brukers.get(index);
    return aBruker;
  }

  public List<Bruker> getBrukers()
  {
    List<Bruker> newBrukers = Collections.unmodifiableList(brukers);
    return newBrukers;
  }

  public int numberOfBrukers()
  {
    int number = brukers.size();
    return number;
  }

  public boolean hasBrukers()
  {
    boolean has = brukers.size() > 0;
    return has;
  }

  public int indexOfBruker(Bruker aBruker)
  {
    int index = brukers.indexOf(aBruker);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBrukers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Bruker addBruker(String aBrukernavn)
  {
    return new Bruker(aBrukernavn, this);
  }

  public boolean addBruker(Bruker aBruker)
  {
    boolean wasAdded = false;
    if (brukers.contains(aBruker)) { return false; }
    Brukegruppe existingBrukegruppe = aBruker.getBrukegruppe();
    boolean isNewBrukegruppe = existingBrukegruppe != null && !this.equals(existingBrukegruppe);
    if (isNewBrukegruppe)
    {
      aBruker.setBrukegruppe(this);
    }
    else
    {
      brukers.add(aBruker);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBruker(Bruker aBruker)
  {
    boolean wasRemoved = false;
    //Unable to remove aBruker, as it must always have a brukegruppe
    if (!this.equals(aBruker.getBrukegruppe()))
    {
      brukers.remove(aBruker);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBrukerAt(Bruker aBruker, int index)
  {  
    boolean wasAdded = false;
    if(addBruker(aBruker))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBrukers()) { index = numberOfBrukers() - 1; }
      brukers.remove(aBruker);
      brukers.add(index, aBruker);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBrukerAt(Bruker aBruker, int index)
  {
    boolean wasAdded = false;
    if(brukers.contains(aBruker))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBrukers()) { index = numberOfBrukers() - 1; }
      brukers.remove(aBruker);
      brukers.add(index, aBruker);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBrukerAt(aBruker, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=brukers.size(); i > 0; i--)
    {
      Bruker aBruker = brukers.get(i - 1);
      aBruker.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "gruppenavn" + ":" + getGruppenavn()+ "]";
  }
}