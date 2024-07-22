package com.example.sistemavotacion.Controller;

import com.example.sistemavotacion.Model.Candidate;
import com.example.sistemavotacion.Model.CandidateDAO;
import com.example.sistemavotacion.Model.VoteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class ViewCandidatesController {

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ListView<String> candidatesListView;

    @FXML
    private Label voteCountLabel;

    @FXML
    public void initialize() {
        try {

            imageView1.setImage(new Image(getClass().getResourceAsStream("/com/example/sistemavotacion/View/image/fotoPetro.jpg")));
            imageView2.setImage(new Image(getClass().getResourceAsStream("/com/example/sistemavotacion/View/image/Presidente_Alvaro_Uribe_Velez.jpg")));


            CandidateDAO candidateDAO = new CandidateDAO();
            VoteDAO voteDAO = new VoteDAO();

            List<Candidate> candidates = candidateDAO.getCandidates();
            for (Candidate candidate : candidates) {

                candidatesListView.getItems().add(candidate.getName());


                int voteCount = voteDAO.getVoteCount(candidate.getId());


                voteCountLabel.setText(candidate.getName() + ": " + voteCount + " votos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
