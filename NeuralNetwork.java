import java.util.*;
public class NeuralNetwork{
    private ArrayList<double[][]> weights;
    private int[] NetworkFrame;
    public NeuralNetwork(int[] netFrame){
        weights = new ArrayList<double[][]>();
        NetworkFrame = netFrame;
        for(int i = 0; i < netFrame.length-1; i++){
            weights.add(new double[netFrame[i]][netFrame[i+1]]);
        }
        for(int a = 0; a < weights.size(); a++){
            for(int b = 0; b < weights.get(a).length; b++){
                for(int c = 0; c < weights.get(a)[b].length; c++){
                    weights.get(a)[b][c] = (Math.random()*2)-1;
                }
            }
        }
    }
    public double[] forwardPropagate(double[] input){
        ArrayList<double[]> inputs = new ArrayList<double[]>();
        for(int a = 0; a < NetworkFrame.length; a++){
            if(a == 0){
                inputs.add(input);
            }
            inputs.add(new double[NetworkFrame[a]]);
        }
        for(int a = 0; a < NetworkFrame.length-1; a++){
            for(int b = 0; b < weights.get(a).length; b++){
                for(int c = 0; c < weights.get(a)[b].length; c++){
                    inputs.get(a+1)[c] += sigmoid(inputs.get(a)[b]*weights.get(a)[b][c]);
                }
            }
        }
        for(double[] a: inputs){
            for(double b: a){
                System.out.print(b+" ");
            }
            System.out.println("");
        }
        return inputs.get(inputs.size()-1);
    }
    private double sigmoid(double val){
        return 1 / (1 + Math.exp(-val));
    }
}