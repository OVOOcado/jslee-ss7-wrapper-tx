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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPForwardingOptionsWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;


/**
 * The Class TxMAPForwardingOptionsWrapperTest.
 */
public class TxMAPForwardingOptionsWrapperTest extends WrapperBaseTest {

    /** The tx map forwarding options wrapper. */
    TxMAPForwardingOptionsWrapper txMAPForwardingOptionsWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(true, true, true,
                ExtForwOptionsForwardingReason.msBusy);
        txMAPForwardingOptionsWrapper = new TxMAPForwardingOptionsWrapper(extForwOptions);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMAPForwardingOptionsWrapper);
        TxMAPForwardingOptionsWrapper tx = (TxMAPForwardingOptionsWrapper) deserializeFromFile();

        assertTrue(
                txMAPForwardingOptionsWrapper.getForwardingReason().getValue() == tx.getForwardingReason().getValue());
        assertTrue(txMAPForwardingOptionsWrapper.getTxExtForwOptions().getExtForwOptionsForwardingReason()
                .getCode() == tx.getTxExtForwOptions().getExtForwOptionsForwardingReason().getCode());

    }

}
