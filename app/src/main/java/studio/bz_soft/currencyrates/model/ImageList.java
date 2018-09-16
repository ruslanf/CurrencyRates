package studio.bz_soft.currencyrates.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ImageList implements Parcelable {

    private List<Image> listOfImages;

    public ImageList(List<Image> listOfImages) {
        this.listOfImages = listOfImages;
    }

    protected ImageList(Parcel in) {
        listOfImages = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Creator<ImageList> CREATOR = new Creator<ImageList>() {
        @Override
        public ImageList createFromParcel(Parcel in) {
            return new ImageList(in);
        }

        @Override
        public ImageList[] newArray(int size) {
            return new ImageList[size];
        }
    };

    public List<Image> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<Image> listOfImages) {
        this.listOfImages = listOfImages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listOfImages);
    }
}
