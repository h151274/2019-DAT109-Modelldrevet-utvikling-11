/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 56 "model.ump"
// line 119 "model.ump"
public class Studie
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Studie Attributes
  private String navn;
  private String beskrivelse;

  //Studie Associations
  private List<Prosjekt> prosjekts;
  private Kategori kategori;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Studie(String aNavn, String aBeskrivelse, Kategori aKategori)
  {
    navn = aNavn;
    beskrivelse = aBeskrivelse;
    prosjekts = new ArrayList<Prosjekt>();
    boolean didAddKategori = setKategori(aKategori);
    if (!didAddKategori)
    {
      throw new RuntimeException("Unable to create study due to kategori");
    }
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

  public String getNavn()
  {
    return navn;
  }

  public String getBeskrivelse()
  {
    return beskrivelse;
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
  public Kategori getKategori()
  {
    return kategori;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProsjekts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prosjekt addProsjekt(String aNavn, String aBeskrivelse, Bruker aBruker, Bedrift aBedrift)
  {
    return new Prosjekt(aNavn, aBeskrivelse, this, aBruker, aBedrift);
  }

  public boolean addProsjekt(Prosjekt aProsjekt)
  {
    boolean wasAdded = false;
    if (prosjekts.contains(aProsjekt)) { return false; }
    Studie existingStudie = aProsjekt.getStudie();
    boolean isNewStudie = existingStudie != null && !this.equals(existingStudie);
    if (isNewStudie)
    {
      aProsjekt.setStudie(this);
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
    //Unable to remove aProsjekt, as it must always have a studie
    if (!this.equals(aProsjekt.getStudie()))
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
  public boolean setKategori(Kategori aKategori)
  {
    boolean wasSet = false;
    if (aKategori == null)
    {
      return wasSet;
    }

    Kategori existingKategori = kategori;
    kategori = aKategori;
    if (existingKategori != null && !existingKategori.equals(aKategori))
    {
      existingKategori.removeStudy(this);
    }
    kategori.addStudy(this);
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
    Kategori placeholderKategori = kategori;
    this.kategori = null;
    if(placeholderKategori != null)
    {
      placeholderKategori.removeStudy(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "navn" + ":" + getNavn()+ "," +
            "beskrivelse" + ":" + getBeskrivelse()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "kategori = "+(getKategori()!=null?Integer.toHexString(System.identityHashCode(getKategori())):"null");
  }
}