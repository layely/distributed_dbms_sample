package distribution_management;

import database.ProprietaireDAO;
import database.SingletonConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import metier.Proprietaire;

/**
 *
 * @author layely
 */
public class TransactionAjouterProprietaire extends Transaction {

    private Proprietaire p;
    private ProprietaireDAO pDAO;

    private int niveauVerrouillage;

    public TransactionAjouterProprietaire(Proprietaire p) {
        pDAO = new ProprietaireDAO();
        this.p = p;
    }

    @Override
    public void run() {

        //Verouillage de la table Proprietaire
        Verrou.tableProprietaireVerrou.readLock().lock();
        this.addVerrou(Verrou.tableProprietaireVerrou);
        Verrou.tableProprietaireVerrou.writeLock().lock();
        //Aquisition des verrous
        //Execution des updates
        Connection connDak = SingletonConnection.getConnection("dakar");
        Connection connThies = SingletonConnection.getConnection("thies");

        try {
            connDak.setAutoCommit(false);
            Statement stat = connDak.createStatement();
            ResultSet res = stat.executeQuery("BEGIN");
            res.close();
            if (!pDAO.addProprietaire("dakar", p)) {
                res = stat.executeQuery("ABORT");
                res.close();
                stat.close();
                return;
            }
            stat.close();

            connThies.setAutoCommit(false);
            Statement statmnt = connThies.createStatement();
            ResultSet resT = statmnt.executeQuery("BEGIN");
            resT.close();
            if (!pDAO.addProprietaire("thies", p)) {
                resT = stat.executeQuery("ABORT");
                resT.close();
                stat.close();
                return;
            }
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Liberation des vérrous
        libererVerous();
    }

}
