package ism.inscription.core;

import ism.inscription.repositories.IClasseProfesseurRepository;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.repositories.IProfRepository;
import ism.inscription.repositories.IUserRepository;
import ism.inscription.repositories.bd.ClasseProfesseurRepository;
import ism.inscription.repositories.bd.ClasseRepository;
import ism.inscription.repositories.bd.EtudiantRepository;
import ism.inscription.repositories.bd.InscriptionRepository;
import ism.inscription.repositories.bd.ProfRepository;
import ism.inscription.repositories.bd.UserRepository;
import ism.inscription.services.EcoleService;
import ism.inscription.services.IEcoleService;

public class Fabrique {
    static IClasseRepository classeRepository = new ClasseRepository();
    static IProfRepository profRepository = new ProfRepository();
    static IEtudiantRepository etudiantRepository = new EtudiantRepository(classeRepository);
    static IUserRepository userRepository = new UserRepository();
    static IClasseProfesseurRepository classeProfRepository = new ClasseProfesseurRepository();
    static IInscriptionRepository inscriptionRepository = new InscriptionRepository();

    public static IEcoleService getService() {
        return new EcoleService(classeRepository, classeProfRepository, etudiantRepository, inscriptionRepository,
                profRepository, userRepository);
    }

}
