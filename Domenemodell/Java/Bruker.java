/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 25 "model.ump"
// line 90 "model.ump"
public class Bruker
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bruker Attributes
  private String brukernavn;

  //Bruker Associations
  private List<Prosjekt> prosjekts;
  private Brukegruppe brukegruppe;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bruker(String aBrukernavn, Brukegruppe aBrukegruppe)
  {
    brukernavn = aBrukernavn;
    prosjekts = new ArrayList<Prosjekt>();
    boolean didAddBrukegruppe = setBrukegruppe(aBrukegruppe);
    if (!didAddBrukegruppe)
    {
      throw new RuntimeException("Unable to create bruker due to brukegruppe");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBrukernavn(String aBrukernavn)
  {
    boolean wasSet = false;
    brukernavn = aBrukernavn;
    wasSet = true;
    return wasSet;
  }

  public String getBrukernavn()
  {
    return brukernavn;
  }
  /* Code from template association_GetMany */
  public Prosjekt getProsjekt(int index)
  {
    Prosjekt aProsjekt = prosjekts.get(index);
    return aProsjekt;
  }

  public List<Prosjekt> getProsjekts()
  {
    List<Prosjekt> newProsjekts = Collections.unmodifiableList(prosjekts);
    return newProsjekts;
  }

  public int numberOfProsjekts()
  {
    int number = prosjekts.size();
    return number;
  }

  public boolean hasProsjekts()
  {
    boolean has = prosjekts.size() > 0;
    return has;
  }

  public int indexOfProsjekt(Prosjekt aProsjekt)
  {
    int index = prosjekts.indexOf(aProsjekt);
    return index;
  }
  /* Code from template association_GetOne */
  public Brukegruppe getBrukegruppe()
  {
    return brukegruppe;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProsjekts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prosjekt addProsjekt(String aNavn, String aBeskrivelse, Studie aStudie, Bedrift aBedrift)
  {
    return new Prosjekt(aNavn, aBeskrivelse, aStudie, this, aBedrift);
  }

  public boolean addProsjekt(Prosjekt aProsjekt)
  {
    boolean wasAdded = false;
    if (prosjekts.contains(aProsjekt)) { return false; }
    Bruker existingBruker = aProsjekt.getBruker();
    boolean isNewBruker = existingBruker != null && !this.equals(existingBruker);
    if (isNewBruker)
    {
      aProsjekt.setBruker(this);
    }
    else
    {
      prosjekts.add(aProsjekt);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProsjekt(Prosjekt aProsjekt)
  {
    boolean wasRemoved = false;
    //Unable to remove aProsjekt, as it must always have a bruker
    if (!this.equals(aProsjekt.getBruker()))
    {
      prosjekts.remove(aProsjekt);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addProsjektAt(Prosjekt aProsjekt, int index)
  {  
    boolean wasAdded = false;
    if(addProsjekt(aProsjekt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProsjekts()) { index = numberOfProsjekts() - 1; }
      prosjekts.remove(aProsjekt);
      prosjekts.add(index, aProsjekt);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProsjektAt(Prosjekt aProsjekt, int index)
  {
    boolean wasAdded = false;
    if(prosjekts.contains(aProsjekt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProsjekts()) { index = numberOfProsjekts() - 1; }
      prosjekts.remove(aProsjekt);
      prosjekts.add(index, aProsjekt);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProsjektAt(aProsjekt, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBrukegruppe(Brukegruppe aBrukegruppe)
  {
    boolean wasSet = false;
    if (aBrukegruppe == null)
    {
      return wasSet;
    }

    Brukegruppe existingBrukegruppe = brukegruppe;
    brukegruppe = aBrukegruppe;
    if (existingBrukegruppe != null && !existingBrukegruppe.equals(aBrukegruppe))
    {
      existingBrukegruppe.removeBruker(this);
    }
    brukegruppe.addBruker(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=prosjekts.size(); i > 0; i--)
    {
      Prosjekt aProsjekt = prosjekts.get(i - 1);
      aProsjekt.delete();
    }
    Brukegruppe placeholderBrukegruppe = brukegruppe;
    this.brukegruppe = null;
    if(placeholderBrukegruppe != null)
    {
      placeholderBrukegruppe.removeBruker(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "brukernavn" + ":" + getBrukernavn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "brukegruppe = "+(getBrukegruppe()!=null?Integer.toHexString(System.identityHashCode(getBrukegruppe())):"null");
  }
}