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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationType;


/**
 * The Class TxCallInformationRequestArgWrapperTest.
 */
public class TxCallInformationRequestArgWrapperTest extends WrapperBaseTest {

    /** The tx call information request arg wrapper. */
    TxCallInformationRequestArgWrapper txCallInformationRequestArgWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        txCallInformationRequestArgWrapper = new TxCallInformationRequestArgWrapper();

        RequestedInformationType requestedInformationType = RequestedInformationType.valueOf(
                org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType.callConnectedElapsedTime
                        .getCode());
        RequestedInformationType[] requestedInformationTypes = new RequestedInformationType[1];
        requestedInformationTypes[0] = requestedInformationType;
        txCallInformationRequestArgWrapper.setRequestedInformationTypeList(requestedInformationTypes);

    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Test
    public void testSerialization() throws ClassNotFoundException, IOException {

        serializeToFile(txCallInformationRequestArgWrapper);
        TxCallInformationRequestArgWrapper tx = (TxCallInformationRequestArgWrapper) deserializeFromFile();

        assertTrue(txCallInformationRequestArgWrapper.getTxRequestedInformationTypes().get(0).getCode() == tx
                .getTxRequestedInformationTypes().get(0).getCode());
    }

}
