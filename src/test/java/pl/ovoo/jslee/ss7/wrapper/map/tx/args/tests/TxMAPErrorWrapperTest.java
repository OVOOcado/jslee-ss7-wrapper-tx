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

import java.io.IOException;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import org.mobicents.protocols.ss7.map.errors.MAPErrorMessageAbsentSubscriberImpl;
import org.mobicents.protocols.ss7.map.errors.MAPErrorMessageCUGRejectImpl;
import org.mobicents.protocols.ss7.map.errors.MAPErrorMessagePwRegistrationFailureImpl;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper.ErrorCode;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPErrorWrapper;

public class TxMAPErrorWrapperTest extends WrapperBaseTest {

    MAPErrorWrapper mapError1;
    MAPErrorWrapper mapError2;
    MAPErrorWrapper mapError3;

    @Before
    public void setUp() throws Exception {

        MAPErrorMessageAbsentSubscriberImpl mapErrorMessageAbsentSubscriberImpl = new MAPErrorMessageAbsentSubscriberImpl(
                true);
        MAPErrorMessageCUGRejectImpl mapErrorMessageCUGRejectImpl = new MAPErrorMessageCUGRejectImpl();
        MAPErrorMessagePwRegistrationFailureImpl mapErrorMessagePwRegistrationFailureImpl = new MAPErrorMessagePwRegistrationFailureImpl();

        MAPErrorMessage mapErrorMessage1 = (MAPErrorMessage) mapErrorMessageAbsentSubscriberImpl;
        mapError1 = new TxMAPErrorWrapper(mapErrorMessage1);
        ErrorCode messageErrorCode1 = mapError1.getMapErrorMessage().getMessageErrorCode();

        MAPErrorMessage mapErrorMessage2 = (MAPErrorMessage) mapErrorMessageCUGRejectImpl;
        mapError2 = new TxMAPErrorWrapper(mapErrorMessage2);
        ErrorCode messageErrorCode2 = mapError2.getMapErrorMessage().getMessageErrorCode();

        MAPErrorMessage mapErrorMessage3 = (MAPErrorMessage) mapErrorMessagePwRegistrationFailureImpl;
        mapError3 = new TxMAPErrorWrapper(mapErrorMessage3);
        ErrorCode messageErrorCode3 = mapError3.getMapErrorMessage().getMessageErrorCode();

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(mapError1);
        MAPErrorWrapper map = (MAPErrorWrapper) deserializeFromFile();
        assertTrue(
                mapError1.getMapErrorMessage().getMessageErrorCode() == map.getMapErrorMessage().getMessageErrorCode());

        serializeToFile(mapError2);
        map = (MAPErrorWrapper) deserializeFromFile();
        assertTrue(
                mapError2.getMapErrorMessage().getMessageErrorCode() == map.getMapErrorMessage().getMessageErrorCode());

        serializeToFile(mapError3);
        map = (MAPErrorWrapper) deserializeFromFile();
        assertTrue(
                mapError3.getMapErrorMessage().getMessageErrorCode() == map.getMapErrorMessage().getMessageErrorCode());

    }

}
