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
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxBearerCapabilityWrapper;


/**
 * The Class TxBearerCapabilityWrapperTest.
 */
public class TxBearerCapabilityWrapperTest extends WrapperBaseTest {

    /** The tx bearer capability wrapper. */
    TxBearerCapabilityWrapper txBearerCapabilityWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        UserServiceInformation userServiceInformation = isupFactory.createUserServiceInformation();
        userServiceInformation.setAssignor(UserServiceInformation._ASS_ASSIGNOR_ONLY);
        userServiceInformation.setInformationTransferCapability(10);

        BearerCap bearerCap = capFactory.createBearerCap(userServiceInformation);
        BearerCapability bearerCapability = capFactory.createBearerCapability(bearerCap);

        txBearerCapabilityWrapper = new TxBearerCapabilityWrapper(bearerCapability);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Test
    public void testSerialization() throws ClassNotFoundException, IOException, CAPException, Ss7WrapperException {

        serializeToFile(txBearerCapabilityWrapper);
        TxBearerCapabilityWrapper tx = (TxBearerCapabilityWrapper) deserializeFromFile();

        assertTrue(txBearerCapabilityWrapper.getTxBearerCapability().getBearerCap().getUserServiceInformation()
                .getInformationTransferCapability() == tx.getTxBearerCapability().getBearerCap()
                        .getUserServiceInformation().getInformationTransferCapability());

    }

}
