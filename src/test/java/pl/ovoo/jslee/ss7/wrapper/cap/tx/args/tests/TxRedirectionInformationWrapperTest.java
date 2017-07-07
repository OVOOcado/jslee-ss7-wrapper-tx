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

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectionInformation;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxRedirectionInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;

public class TxRedirectionInformationWrapperTest extends WrapperBaseTest {

    TxRedirectionInformationWrapper txRedirectionInformationWrapper;

    @Before
    public void setUp() throws Exception {

        final RedirectionInformation redirectionInformation = isupFactory.createRedirectionInformation();
        redirectionInformation.setOriginalRedirectionReason(RedirectionInformation._ORR_USER_BUSY);
        redirectionInformation.setRedirectingIndicator(RedirectionInformation._RI_CALL_D_RNPR);
        redirectionInformation.setRedirectionCounter(2);
        redirectionInformation.setRedirectionReason(RedirectionInformation._RR_MOBILE_SNR);
        final RedirectionInformationInap redirectionInformationInap = inapFactory
                .createRedirectionInformationInap(redirectionInformation);
        txRedirectionInformationWrapper = new TxRedirectionInformationWrapper(redirectionInformationInap);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRedirectionInformationWrapper);
        TxRedirectionInformationWrapper tx = (TxRedirectionInformationWrapper) deserializeFromFile();

        assertTrue(tx.hasOriginalReason());
        assertTrue(tx.hasRedirecting());
        assertTrue(tx.hasRedirectingReason());
        assertEquals(
                txRedirectionInformationWrapper.getTxRedirectionInformation().getRedirectionInformation()
                        .getRedirectingIndicator(),
                tx.getTxRedirectionInformation().getRedirectionInformation().getRedirectingIndicator());

    }

}
