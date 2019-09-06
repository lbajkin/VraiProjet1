package Items.Armures;

import Items.Item;

public class FailedNuclearExperiment extends Item  {
    public FailedNuclearExperiment() {
        setNom("Failed Nuclear Experiment");
        setValue(6);
        setEffet(getNom() + " vous donne " + getValue() + " defense");
        setType(4);
    }}
