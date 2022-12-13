package champollion;

import java.util.Objects;

public class ServicePrevu {

    private int volumeCM;
    private int volumeTD;
    private int volumeTP;


    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;

    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void addVolume(int volumeCM, int volumeTD, int volumeTP){

        this.volumeCM+=volumeCM;
        this.volumeTD+=volumeTD;
        this.volumeTP+=volumeTP;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePrevu that = (ServicePrevu) o;
        return volumeCM == that.volumeCM && volumeTD == that.volumeTD && volumeTP == that.volumeTP ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumeCM, volumeTD, volumeTP);
    }



}
