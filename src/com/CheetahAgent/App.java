package com.CheetahAgent;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Sigar sigar=new Sigar();
        
        CpuPerc cpu=null;
        try {
			cpu=sigar.getCpuPerc();
		} catch (SigarException e) {
			e.printStackTrace();
		}
        System.out.println("user perc:"+(float)Math.round(cpu.getUser()*10000)/100+"%");
        System.out.println("sys perc:"+(float)Math.round(cpu.getSys()*10000)/100+"%");
        Mem mem = null;
        try {
            mem = sigar.getMem();
        } catch (SigarException se) {
            se.printStackTrace();
        }

        System.out.println("Actual total free system memory: "
                + mem.getActualFree() / 1024 / 1024+ " MB");
        System.out.println("Actual total used system memory: "
                + mem.getActualUsed() / 1024 / 1024 + " MB");
        System.out.println("Total free system memory ......: " + mem.getFree()
                / 1024 / 1024+ " MB");
        System.out.println("System Random Access Memory....: " + mem.getRam()
                + " MB");
        System.out.println("Total system memory............: " + mem.getTotal()
                / 1024 / 1024+ " MB");
        System.out.println("Total used system memory.......: " + mem.getUsed()
                / 1024 / 1024+ " MB");
    }
}
