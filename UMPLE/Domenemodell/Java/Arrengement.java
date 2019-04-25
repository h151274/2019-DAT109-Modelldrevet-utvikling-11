/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.sql.Date;
import java.util.*;

// line 44 "model.ump"
// line 108 "model.ump"
public class Arrengement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Arrengement Attributes
  private String navn;
  private String beskrivelse;
  private Date utgaar;

  //Arrengement Associations
  private Stemmemetode stemmemetode;
  private List<Arrangementdeltagelse> arrangementdeltagelses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Arrengement(String aNavn, String aBeskrivelse, Date aUtgaar, Stemmemetode aStemmemetode)
  {
    navn = aNavn;
    beskrivelse = aBeskrivelse;
    utgaar = aUtgaar;
    boolean didAddStemmemetode = setStemmemetode(aStemmemetode);
    if (!didAddStemmemetode)
    {
      throw new RuntimeException("Unable to create arrengement due to stemmemetode");
    }
    arrangementdeltagelses = new ArrayList<Arrangementdeltagelse>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNavn(String aNavn)
  {
    boolean wasSet = false;
    navn = aNavn;
    wasSet = true;
    return wasSet;
  }

  public boolean setBeskrivelse(String aBeskrivelse)
  {
    boolean wasSet = false;
    beskrivelse = aBeskrivelse;
    wasSet = true;
    return wasSet;
  }

  public boolean setUtgaar(Date aUtgaar)
  {
    boolean wasSet = false;
    utgaar = aUtgaar;
    wasSet = true;
    return wasSet;
  }

  public String getNavn()
  {
    return navn;
  }

  public String getBeskrivelse()
  {
    return beskrivelse;
  }

  public Date getUtgaar()
  {
    return utgaar;
  }
  /* Code from template association_GetOne */
  public Stemmemetode getStemmemetode()
  {
    return stemmemetode;
  }
  /* Code from template association_GetMany */
  public Arrangementdeltagelse getArrangementdeltagelse(int index)
  {
    Arrangementdeltagelse aArrangementdeltagelse = arrangementdeltagelses.get(index);
    return aArrangementdeltagelse;
  }

  public List<Arrangementdeltagelse> getArrangementdeltagelses()
  {
    List<Arrangementdeltagelse> newArrangementdeltagelses = Collections.unmodifiableList(arrangementdeltagelses);
    return newArrangementdeltagelses;
  }

  public int numberOfArrangementdeltagelses()
  {
    int number = arrangementdeltagelses.size();
    return number;
  }

  public boolean hasArrangementdeltagelses()
  {
    boolean has = arrangementdeltagelses.size() > 0;
    return has;
  }

  public int indexOfArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    int index = arrangementdeltagelses.indexOf(aArrangementdeltagelse);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStemmemetode(Stemmemetode aStemmemetode)
  {
    boolean wasSet = false;
    if (aStemmemetode == null)
    {
      return wasSet;
    }

    Stemmemetode existingStemmemetode = stemmemetode;
    stemmemetode = aStemmemetode;
    if (existingStemmemetode != null && !existingStemmemetode.equals(aStemmemetode))
    {
      existingStemmemetode.removeArrengement(this);
    }
    stemmemetode.addArrengement(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArrangementdeltagelses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Arrangementdeltagelse addArrangementdeltagelse(Prosjekt aProsjekt)
  {
    return new Arrangementdeltagelse(aProsjekt, this);
  }

  public boolean addArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    boolean wasAdded = false;
    if (arrangementdeltagelses.contains(aArrangementdeltagelse)) { return false; }
    Arrengement existingArrengement = aArrangementdeltagelse.getArrengement();
    boolean isNewArrengement = existingArrengement != null && !this.equals(existingArrengement);
    if (isNewArrengement)
    {
      aArrangementdeltagelse.setArrengement(this);
    }
    else
    {
      arrangementdeltagelses.add(aArrangementdeltagelse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    boolean wasRemoved = false;
    //Unable to remove aArrangementdeltagelse, as it must always have a arrengement
    if (!this.equals(aArrangementdeltagelse.getArrengement()))
    {
      arrangementdeltagelses.remove(aArrangementdeltagelse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArrangementdeltagelseAt(Arrangementdeltagelse aArrangementdeltagelse, int index)
  {  
    boolean wasAdded = false;
    if(addArrangementdeltagelse(aArrangementdeltagelse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrangementdeltagelses()) { index = numberOfArrangementdeltagelses() - 1; }
      arrangementdeltagelses.remove(aArrangementdeltagelse);
      arrangementdeltagelses.add(index, aArrangementdeltagelse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArrangementdeltagelseAt(Arrangementdeltagelse aArrangementdeltagelse, int index)
  {
    boolean wasAdded = false;
    if(arrangementdeltagelses.contains(aArrangementdeltagelse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrangementdeltagelses()) { index = numberOfArrangementdeltagelses() - 1; }
      arrangementdeltagelses.remove(aArrangementdeltagelse);
      arrangementdeltagelses.add(index, aArrangementdeltagelse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArrangementdeltagelseAt(aArrangementdeltagelse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Stemmemetode placeholderStemmemetode = stemmemetode;
    this.stemmemetode = null;
    if(placeholderStemmemetode != null)
    {
      placeholderStemmemetode.removeArrengement(this);
    }
    for(int i=arrangementdeltagelses.size(); i > 0; i--)
    {
      Arrangementdeltagelse aArrangementdeltagelse = arrangementdeltagelses.get(i - 1);
      aArrangementdeltagelse.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "navn" + ":" + getNavn()+ "," +
            "beskrivelse" + ":" + getBeskrivelse()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "utgaar" + "=" + (getUtgaar() != null ? !getUtgaar().equals(this)  ? getUtgaar().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "stemmemetode = "+(getStemmemetode()!=null?Integer.toHexString(System.identityHashCode(getStemmemetode())):"null");
  }
}