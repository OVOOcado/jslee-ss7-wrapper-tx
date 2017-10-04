/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.test;

import org.mobicents.protocols.ss7.cap.CAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.cap.api.CAPParameterFactory;
import org.mobicents.protocols.ss7.isup.ISUPParameterFactory;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.ISUPParameterFactoryImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.INAPParameterFactory;
import org.mobicents.protocols.ss7.inap.isup.INAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.sccp.impl.parameter.ParameterFactoryImpl;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;


/**
 * The Class WrapperBaseTest.
 */
public abstract class WrapperBaseTest {

    /** The serialize file path. */
    private final String serializeFilePath = "testFile.ser";

    /** The map parameter factory. */
    public MAPParameterFactory mapParameterFactory;
    
    /** The isup factory. */
    public ISUPParameterFactory isupFactory;
    
    /** The cap factory. */
    public CAPParameterFactory capFactory;
    
    /** The inap factory. */
    public INAPParameterFactory inapFactory;
    
    /** The parameter factory. */
    public ParameterFactory parameterFactory;

    /**
     * Instantiates a new wrapper base test.
     */
    public WrapperBaseTest() {

        mapParameterFactory = new MAPParameterFactoryImpl();
        inapFactory = new INAPParameterFactoryImpl();
        capFactory = new CAPParameterFactoryImpl();
        isupFactory = new ISUPParameterFactoryImpl();
        parameterFactory = new ParameterFactoryImpl();

    }

    /**
     * Serialize to file.
     *
     * @param obj the obj
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void serializeToFile(Object obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(serializeFilePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    /**
     * Deserialize from file.
     *
     * @return the object
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClassNotFoundException the class not found exception
     */
    public Object deserializeFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(serializeFilePath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object ob = in.readObject();
        in.close();
        fileIn.close();

        return ob;
    }

    /**
     * Test serialization.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClassNotFoundException the class not found exception
     * @throws CAPException the CAP exception
     * @throws Ss7WrapperException the SS7 Wrapper exception
     * @throws INAPException the INAP exception
     * @throws MAPException the MAP exception
     */
    @Test
    public abstract void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException;

}
