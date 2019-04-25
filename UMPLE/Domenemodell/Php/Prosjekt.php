<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

// Unable to update umple code due to error at [4,2]
class Prosjekt
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Prosjekt Attributes
  private $navn;
  private $beskrivelse;

  //Prosjekt Associations
  private $studie;
  private $arrangementdeltagelses;
  private $bruker;
  private $bedrift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNavn, $aBeskrivelse, $aStudie, $aBruker, $aBedrift)
  {
    $this->navn = $aNavn;
    $this->beskrivelse = $aBeskrivelse;
    $didAddStudie = $this->setStudie($aStudie);
    if (!$didAddStudie)
    {
      throw new Exception("Unable to create prosjekt due to studie");
    }
    $this->arrangementdeltagelses = array();
    $didAddBruker = $this->setBruker($aBruker);
    if (!$didAddBruker)
    {
      throw new Exception("Unable to create prosjekt due to bruker");
    }
    $didAddBedrift = $this->setBedrift($aBedrift);
    if (!$didAddBedrift)
    {
      throw new Exception("Unable to create prosjekt due to bedrift");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setNavn($aNavn)
  {
    $wasSet = false;
    $this->navn = $aNavn;
    $wasSet = true;
    return $wasSet;
  }

  public function setBeskrivelse($aBeskrivelse)
  {
    $wasSet = false;
    $this->beskrivelse = $aBeskrivelse;
    $wasSet = true;
    return $wasSet;
  }

  public function getNavn()
  {
    return $this->navn;
  }

  public function getBeskrivelse()
  {
    return $this->beskrivelse;
  }

  public function getStudie()
  {
    return $this->studie;
  }

  public function getArrangementdeltagelse_index($index)
  {
    $aArrangementdeltagelse = $this->arrangementdeltagelses[$index];
    return $aArrangementdeltagelse;
  }

  public function getArrangementdeltagelses()
  {
    $newArrangementdeltagelses = $this->arrangementdeltagelses;
    return $newArrangementdeltagelses;
  }

  public function numberOfArrangementdeltagelses()
  {
    $number = count($this->arrangementdeltagelses);
    return $number;
  }

  public function hasArrangementdeltagelses()
  {
    $has = $this->numberOfArrangementdeltagelses() > 0;
    return $has;
  }

  public function indexOfArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->arrangementdeltagelses as $arrangementdeltagelse)
    {
      if ($arrangementdeltagelse->equals($aArrangementdeltagelse))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getBruker()
  {
    return $this->bruker;
  }

  public function getBedrift()
  {
    return $this->bedrift;
  }

  public function setStudie($aStudie)
  {
    $wasSet = false;
    if ($aStudie == null)
    {
      return $wasSet;
    }
    
    $existingStudie = $this->studie;
    $this->studie = $aStudie;
    if ($existingStudie != null && $existingStudie != $aStudie)
    {
      $existingStudie->removeProsjekt($this);
    }
    $this->studie->addProsjekt($this);
    $wasSet = true;
    return $wasSet;
  }

  public static function minimumNumberOfArrangementdeltagelses()
  {
    return 0;
  }

  public function addArrangementdeltagelseVia($aArrengement)
  {
    return new Arrangementdeltagelse($this, $aArrengement);
  }

  public function addArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasAdded = false;
    if ($this->indexOfArrangementdeltagelse($aArrangementdeltagelse) !== -1) { return false; }
    $existingProsjekt = $aArrangementdeltagelse->getProsjekt();
    $isNewProsjekt = $existingProsjekt != null && $this !== $existingProsjekt;
    if ($isNewProsjekt)
    {
      $aArrangementdeltagelse->setProsjekt($this);
    }
    else
    {
      $this->arrangementdeltagelses[] = $aArrangementdeltagelse;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasRemoved = false;
    //Unable to remove aArrangementdeltagelse, as it must always have a prosjekt
    if ($this !== $aArrangementdeltagelse->getProsjekt())
    {
      unset($this->arrangementdeltagelses[$this->indexOfArrangementdeltagelse($aArrangementdeltagelse)]);
      $this->arrangementdeltagelses = array_values($this->arrangementdeltagelses);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addArrangementdeltagelseAt($aArrangementdeltagelse, $index)
  {  
    $wasAdded = false;
    if($this->addArrangementdeltagelse($aArrangementdeltagelse))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrangementdeltagelses()) { $index = $this->numberOfArrangementdeltagelses() - 1; }
      array_splice($this->arrangementdeltagelses, $this->indexOfArrangementdeltagelse($aArrangementdeltagelse), 1);
      array_splice($this->arrangementdeltagelses, $index, 0, array($aArrangementdeltagelse));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveArrangementdeltagelseAt($aArrangementdeltagelse, $index)
  {
    $wasAdded = false;
    if($this->indexOfArrangementdeltagelse($aArrangementdeltagelse) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrangementdeltagelses()) { $index = $this->numberOfArrangementdeltagelses() - 1; }
      array_splice($this->arrangementdeltagelses, $this->indexOfArrangementdeltagelse($aArrangementdeltagelse), 1);
      array_splice($this->arrangementdeltagelses, $index, 0, array($aArrangementdeltagelse));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addArrangementdeltagelseAt($aArrangementdeltagelse, $index);
    }
    return $wasAdded;
  }

  public function setBruker($aBruker)
  {
    $wasSet = false;
    if ($aBruker == null)
    {
      return $wasSet;
    }
    
    $existingBruker = $this->bruker;
    $this->bruker = $aBruker;
    if ($existingBruker != null && $existingBruker != $aBruker)
    {
      $existingBruker->removeProsjekt($this);
    }
    $this->bruker->addProsjekt($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setBedrift($aBedrift)
  {
    $wasSet = false;
    if ($aBedrift == null)
    {
      return $wasSet;
    }
    
    $existingBedrift = $this->bedrift;
    $this->bedrift = $aBedrift;
    if ($existingBedrift != null && $existingBedrift != $aBedrift)
    {
      $existingBedrift->removeProsjekt($this);
    }
    $this->bedrift->addProsjekt($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderStudie = $this->studie;
    $this->studie = null;
    $placeholderStudie->removeProsjekt($this);
    foreach ($this->arrangementdeltagelses as $aArrangementdeltagelse)
    {
      $aArrangementdeltagelse->delete();
    }
    $placeholderBruker = $this->bruker;
    $this->bruker = null;
    $placeholderBruker->removeProsjekt($this);
    $placeholderBedrift = $this->bedrift;
    $this->bedrift = null;
    $placeholderBedrift->removeProsjekt($this);
  }

}
?>