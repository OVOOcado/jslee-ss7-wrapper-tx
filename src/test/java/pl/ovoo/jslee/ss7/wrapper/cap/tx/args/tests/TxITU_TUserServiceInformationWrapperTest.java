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
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxITU_TUserServiceInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxITU_TUserServiceInformationWrapperTest extends WrapperBaseTest {

    TxITU_TUserServiceInformationWrapper txITU_TUserServiceInformationWrapper;

    @Before
    public void setUp() throws Exception {

        UserServiceInformation userServiceInformation = isupFactory.createUserServiceInformation();
        userServiceInformation.setHDR(UserServiceInformation._HDR_INCLUDED);
        userServiceInformation.setCodingStandart(UserServiceInformation._CS_CCITT);
        userServiceInformation.setInformationTransferCapability(UserServiceInformation._ITR_1536);
        txITU_TUserServiceInformationWrapper = new TxITU_TUserServiceInformationWrapper(userServiceInformation);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txITU_TUserServiceInformationWrapper);
        TxITU_TUserServiceInformationWrapper tx = (TxITU_TUserServiceInformationWrapper) deserializeFromFile();

        assertTrue(txITU_TUserServiceInformationWrapper.getTransferCapability().getValue() == tx.getTransferCapability()
                .getValue());
        assertTrue(txITU_TUserServiceInformationWrapper.getTxUserServiceInformation().getHDR() == tx
                .getTxUserServiceInformation().getHDR());

    }

}
