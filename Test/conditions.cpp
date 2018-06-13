// Sortie de route droite
bool RightOut(int captorDroiteEx, int captorGaucheEx, int captorDroite, int captorGauche){
  if (captorDroite == 1 && captorDroiteEx == 0) {
    return true;
  }
  else return false;
}

// Sortie de route gauche
bool LeftOut(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
    if (captorGauche == 1 && captorGaucheEx == 0) {
    return true;
  }
  else return false;
}

// Route à droite
bool IsThereARightRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
  if(captorDroite == 1 && captorDroiteEx == 1 && captorGauche == 0 && captorGaucheEx == 0) {
  return true;
  }
  else return false;
}

// Route à gauche 
bool IsThereALeftRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
    if(captorGauche == 1 && captorGaucheEx == 1 && captorDroite == 0 && captorDroiteEx == 0) {
  return true;
  }
  else return false;
}

// Routes à gauche et à droite
bool AreThereLeftAndRightRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
  if(captorDroite == 1 && captorDroiteEx == 1 && captorGauche == 1 && captorGaucheEx == 1) {
    return true;
  }
  else return false;
}

// Route en face (lors d'un tournant droite)
bool IsThereAFrontRoadWhenUTurnRight(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
  if(captorGauche == 1) {
    return true;
  }
  else return false;
}

// Route en face (lors d'un tournant gauche)
bool IsThereAFrontRoadWhenUTurnLeft(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche) {
  if(captorDroite == 1) {
    return true;
  }
  else return false;
}

