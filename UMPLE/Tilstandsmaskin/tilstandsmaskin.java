//%% NEW FILE EXPO BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/



/**
 * @@@skipcppcompile - Contains Java Code
 * @@@skipphpcompile - Contains Java Code
 * @@@skiprubycompile - Contains Java Code
 */
// line 2 "model.ump"
// line 43 "model.ump"
// line 48 "model.ump"
public class EXPO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EXPO State Machines
  public enum Expo { lagBruker, Adminbruker, statestikk, Gruppekonto, Stand, Brukerkonto, Stemme, lageEllerOppdatereEXPO, DONE }
  private Expo expo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EXPO()
  {
    setExpo(Expo.lagBruker);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getExpoFullName()
  {
    String answer = expo.toString();
    return answer;
  }

  public Expo getExpo()
  {
    return expo;
  }

  public boolean Bruker()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case lagBruker:
        setExpo(Expo.Brukerkonto);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean Admin()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case lagBruker:
        setExpo(Expo.Adminbruker);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean Gruppe()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case lagBruker:
        setExpo(Expo.Gruppekonto);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean Oppdatere()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Adminbruker:
        setExpo(Expo.lageEllerOppdatereEXPO);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean seStatestikk()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Adminbruker:
        setExpo(Expo.statestikk);
        wasEventProcessed = true;
        break;
      case Gruppekonto:
        setExpo(Expo.statestikk);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ferdig()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case statestikk:
        setExpo(Expo.DONE);
        wasEventProcessed = true;
        break;
      case Stand:
        setExpo(Expo.DONE);
        wasEventProcessed = true;
        break;
      case Stemme:
        setExpo(Expo.DONE);
        wasEventProcessed = true;
        break;
      case lageEllerOppdatereEXPO:
        setExpo(Expo.DONE);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean LageStand()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Gruppekonto:
        setExpo(Expo.Stand);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean QR()
  {
    boolean wasEventProcessed = false;
    
    Expo aExpo = expo;
    switch (aExpo)
    {
      case Brukerkonto:
        setExpo(Expo.Stemme);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setExpo(Expo aExpo)
  {
    expo = aExpo;
  }

  public void delete()
  {}

}