package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.ClasseProfesseur;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;
import ism.inscription.repositories.IClasseProfesseurRepository;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.repositories.IProfRepository;
import ism.inscription.repositories.IUserRepository;

public class EcoleService implements IEcoleService {
     IClasseRepository classeRepository;
     IClasseProfesseurRepository classeProfesseurRepository;
     IEtudiantRepository etudiantRepository;
     IInscriptionRepository inscriptionRepository;
     IProfRepository profRepository;
     IUserRepository userRepository;

     public EcoleService(IClasseRepository classeRepository, IClasseProfesseurRepository classeProfesseurRepository,
               IEtudiantRepository etudiantRepository, IInscriptionRepository inscriptionRepository,
               IProfRepository profRepository, IUserRepository userRepository) {
          this.classeRepository = classeRepository;
          this.classeProfesseurRepository = classeProfesseurRepository;
          this.etudiantRepository = etudiantRepository;
          this.inscriptionRepository = inscriptionRepository;
          this.profRepository = profRepository;
          this.userRepository = userRepository;
     }

     @Override
     public Professeur ajouterProfesseur(Professeur professeur) {
          return profRepository.insert(professeur);
     }

     @Override
     public List<Professeur> listerProfesseurs() {
          return profRepository.findAll();
     }

     @Override
     public Professeur filterProfesseurParClasse(Classe classe) {
          return profRepository.findByClasse(classe);
     }

     @Override
     public Classe ajouterClasse(Classe classe) {
          return classeRepository.insert(classe);
     }

     @Override
     public List<Classe> listerClasses() {
          return classeRepository.findAll();
     }

     @Override
     public Classe filterClasseParLibelle(String libelle) {
          return classeRepository.findByLibelle(libelle);
     }

     @Override
     public Etudiant inscrireEtudiant(Etudiant etudiant) {
          return etudiantRepository.insert(etudiant);
     }

     @Override
     public List<Etudiant> ListerEtudiants() {
          return etudiantRepository.findAll();
     }

     @Override
     public User seConnecter(String login, String password) {
          return userRepository.findUserByLoginAndPassword(login, password);
     }

     @Override
     public List<User> listerUsers() {
          return userRepository.findAll();
     }

     @Override
     public ClasseProfesseur affecterClasseAProfesseur(Professeur professeur, Classe classe) {
          // TODO Auto-generated method stub
          return null;// profRepository.affectClasse()
     }

     @Override
     public Etudiant affecterClasseAEtudiant(Etudiant etudiant, Classe classe) {
          // TODO Auto-generated method stub
          return null;// profRepository.affecteclasse()
     }

     @Override
     public String genererMatricule(Etudiant etudiant) {
          return etudiantRepository.makeMatricule(etudiant);
     }

}
