interface VolumeCalculable {
    int calculateVolume();
}
class Box implements VolumeCalculable {
    private int length;
    private int width;
    private int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public int calculateVolume() {
        return length * width * height;
    }
}

class Cylinder implements VolumeCalculable {
    private int radius;
    private int height;

    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    public int calculateVolume() {
        return (int) (Math.PI * radius * radius * height);
    }
}

class VolumeCalculator {
    private VolumeCalculable shape;

    public VolumeCalculator(VolumeCalculable shape) {
        this.shape = shape;
    }

    public void displayVolume() {
        int volume = shape.calculateVolume();
        System.out.println("The Volume is : " + volume);
    }
}

class Volume {
    public static void main(String args[]) {
        VolumeCalculable box = new Box(10, 10, 10);
        VolumeCalculator calculator = new VolumeCalculator(box);
        calculator.displayVolume();

        VolumeCalculable cylinder = new Cylinder(30, 70);
        VolumeCalculator cylinderCalculator = new VolumeCalculator(cylinder);
        cylinderCalculator.displayVolume();
    }
}