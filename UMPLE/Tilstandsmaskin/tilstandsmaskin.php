//%% NEW FILE EXPO BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

// @@@skipcppcompile - Contains Java Code
// @@@skipphpcompile - Contains Java Code
// @@@skiprubycompile - Contains Java Code
class EXPO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EXPO State Machines
  private static $ExpoLagBruker = 1;
  private static $ExpoAdminbruker = 2;
  private static $ExpoStatestikk = 3;
  private static $ExpoGruppekonto = 4;
  private static $ExpoStand = 5;
  private static $ExpoBrukerkonto = 6;
  private static $ExpoStemme = 7;
  private static $ExpoLageEllerOppdatereEXPO = 8;
  private static $ExpoDONE = 9;
  private $expo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setExpo(self::$ExpoLagBruker);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getExpoFullName()
  {
    $answer = $this->getExpo();
    return $answer;
  }

  public function getExpo()
  {
    if ($this->expo == self::$ExpoLagBruker) { return "ExpoLagBruker"; }
    elseif ($this->expo == self::$ExpoAdminbruker) { return "ExpoAdminbruker"; }
    elseif ($this->expo == self::$ExpoStatestikk) { return "ExpoStatestikk"; }
    elseif ($this->expo == self::$ExpoGruppekonto) { return "ExpoGruppekonto"; }
    elseif ($this->expo == self::$ExpoStand) { return "ExpoStand"; }
    elseif ($this->expo == self::$ExpoBrukerkonto) { return "ExpoBrukerkonto"; }
    elseif ($this->expo == self::$ExpoStemme) { return "ExpoStemme"; }
    elseif ($this->expo == self::$ExpoLageEllerOppdatereEXPO) { return "ExpoLageEllerOppdatereEXPO"; }
    elseif ($this->expo == self::$ExpoDONE) { return "ExpoDONE"; }
    return null;
  }

  public function Bruker()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoLagBruker)
    {
      $this->setExpo(self::$ExpoBrukerkonto);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function Admin()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoLagBruker)
    {
      $this->setExpo(self::$ExpoAdminbruker);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function Gruppe()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoLagBruker)
    {
      $this->setExpo(self::$ExpoGruppekonto);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function Oppdatere()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoAdminbruker)
    {
      $this->setExpo(self::$ExpoLageEllerOppdatereEXPO);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function seStatestikk()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoAdminbruker)
    {
      $this->setExpo(self::$ExpoStatestikk);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoGruppekonto)
    {
      $this->setExpo(self::$ExpoStatestikk);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function ferdig()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoStatestikk)
    {
      $this->setExpo(self::$ExpoDONE);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoStand)
    {
      $this->setExpo(self::$ExpoDONE);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoStemme)
    {
      $this->setExpo(self::$ExpoDONE);
      $wasEventProcessed = true;
    }
    elseif ($aExpo == self::$ExpoLageEllerOppdatereEXPO)
    {
      $this->setExpo(self::$ExpoDONE);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function LageStand()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoGruppekonto)
    {
      $this->setExpo(self::$ExpoStand);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function QR()
  {
    $wasEventProcessed = false;
    
    $aExpo = $this->expo;
    if ($aExpo == self::$ExpoBrukerkonto)
    {
      $this->setExpo(self::$ExpoStemme);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setExpo($aExpo)
  {
    $this->expo = $aExpo;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}