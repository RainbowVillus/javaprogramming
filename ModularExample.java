package kr.easw.lesson04;

public class ModularExample {
    public static int MAX_TICK = 5000;

    public static int INITIAL_FUEL = 5000; // 초기 연료를 5000으로 증가

    public static void main(String[] args) {
        Vehicle vehicle = getVehicle();
        VehicleType type = vehicle.getType();
        int leftFuel = INITIAL_FUEL;
        int leftTick = 0;
        int totalEnergy = 0;
        int tickUsed;
        for (tickUsed = 0; tickUsed < MAX_TICK; tickUsed++) {
            if (leftTick-- > 0) {
                continue;
            }
            Energy energy = vehicle.getEnergy();
            leftTick = Math.max(0, type.tickModify() + energy.tickModify());
            vehicle.onTick(tickUsed, leftFuel);
            if (leftFuel < energy.fuelUsage() + type.getCost()) {
                break;
            }
            leftFuel -= energy.fuelUsage() + type.getCost();
            totalEnergy += energy.createEnergy(tickUsed);
        }
        tickUsed = Math.min(tickUsed, MAX_TICK);
        int percentage = (int) (((double) tickUsed) / ((double) (MAX_TICK)) * 100.0);
        System.out.println("주행이 종료되었습니다!");
        System.out.println("수행률 : " + percentage + "%");
        System.out.println("총 이동거리: " + totalEnergy);
        System.out.println("남은 연료: " + leftFuel);
        System.out.println("최종 점수: " + calculateScore(tickUsed, totalEnergy, leftFuel));
    }

    private static int calculateScore(int totalTick, int totalEnergy, int leftFuel) {
        double fuelUsage = 1.0 - ((double) leftFuel / (double) INITIAL_FUEL);
        double tickUsage = (double) totalTick / (double) MAX_TICK;
        return (int) (100.0 * fuelUsage * tickUsage * totalEnergy);
    }

    public static Vehicle getVehicle() {
        return new CarVehicle();
    }

    static abstract class Vehicle {
        public abstract Energy getEnergy();

        public abstract VehicleType getType();

        public abstract void onTick(int currentTick, int fuel);
    }

    static interface VehicleType {
        int getCost();

        int tickModify();
    }

    static class Bike implements VehicleType {
        @Override
        public int getCost() {
            return 0;
        }

        @Override
        public int tickModify() {
            return -2;
        }
    }

    static class Car implements VehicleType {

        @Override
        public int getCost() {
            return 2; // 주행 틱당 소모 비용을 2로 변경
        }

        @Override
        public int tickModify() {
            return 1; // 틱 수정 값을 1로 변경
        }
    }


    static class CarVehicle extends Vehicle {
        @Override
        public Energy getEnergy() {
            return new CoalEnergy();
        }

        @Override
        public VehicleType getType() {
            return new Car();
        }

        @Override
        public void onTick(int currentTick, int fuel) {
            // 추가 작업 없음
        }
    }

    interface Energy {
        int createEnergy(int tick);

        int fuelUsage();

        int tickModify();
    }

    static class HumanEnergy implements Energy {

        @Override
        public int createEnergy(int tick) {
            if (tick % 5 == 0)
                return 30;
            return 0;
        }

        @Override
        public int fuelUsage() {
            return 0;
        }

        @Override
        public int tickModify() {
            return 5;
        }
    }

    static class CoalEnergy implements Energy {

        @Override
        public int createEnergy(int tick) {
            return 45;
        }

        @Override
        public int fuelUsage() {
            return 10;
        }

        @Override
        public int tickModify() {
            return 5;
        }
    }

    static class SunlightEnergy implements Energy {

        @Override
        public int createEnergy(int tick) {
            return 5;
        }

        @Override
        public int fuelUsage() {
            return 0;
        }

        @Override
        public int tickModify() {
            return 10;
        }
    }
}
