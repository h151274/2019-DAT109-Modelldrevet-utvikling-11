<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Kategori
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Kategori Attributes
  private $navn;
  private $beskrivelse;

  //Kategori Associations
  private $studies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNavn, $aBeskrivelse)
  {
    $this->navn = $aNavn;
    $this->beskrivelse = $aBeskrivelse;
    $this->studies = array();
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

  public function getStudy_index($index)
  {
    $aStudy = $this->studies[$index];
    return $aStudy;
  }

  public function getStudies()
  {
    $newStudies = $this->studies;
    return $newStudies;
  }

  public function numberOfStudies()
  {
    $number = count($this->studies);
    return $number;
  }

  public function hasStudies()
  {
    $has = $this->numberOfStudies() > 0;
    return $has;
  }

  public function indexOfStudy($aStudy)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->studies as $study)
    {
      if ($study->equals($aStudy))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfStudies()
  {
    return 0;
  }

  public function addStudyVia($aNavn, $aBeskrivelse)
  {
    return new Studie($aNavn, $aBeskrivelse, $this);
  }

  public function addStudy($aStudy)
  {
    $wasAdded = false;
    if ($this->indexOfStudy($aStudy) !== -1) { return false; }
    $existingKategori = $aStudy->getKategori();
    $isNewKategori = $existingKategori != null && $this !== $existingKategori;
    if ($isNewKategori)
    {
      $aStudy->setKategori($this);
    }
    else
    {
      $this->studies[] = $aStudy;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStudy($aStudy)
  {
    $wasRemoved = false;
    //Unable to remove aStudy, as it must always have a kategori
    if ($this !== $aStudy->getKategori())
    {
      unset($this->studies[$this->indexOfStudy($aStudy)]);
      $this->studies = array_values($this->studies);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStudyAt($aStudy, $index)
  {  
    $wasAdded = false;
    if($this->addStudy($aStudy))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStudies()) { $index = $this->numberOfStudies() - 1; }
      array_splice($this->studies, $this->indexOfStudy($aStudy), 1);
      array_splice($this->studies, $index, 0, array($aStudy));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStudyAt($aStudy, $index)
  {
    $wasAdded = false;
    if($this->indexOfStudy($aStudy) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStudies()) { $index = $this->numberOfStudies() - 1; }
      array_splice($this->studies, $this->indexOfStudy($aStudy), 1);
      array_splice($this->studies, $index, 0, array($aStudy));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStudyAt($aStudy, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->studies as $aStudy)
    {
      $aStudy->delete();
    }
  }

}
?>