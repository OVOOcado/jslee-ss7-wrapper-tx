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

package pl.ovoo.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectingNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxRedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRedirectingPartyNumberWrapperTest extends WrapperBaseTest {

    TxRedirectingPartyNumberWrapper txRedirectingPartyNumberWrapper;

    @Before
    public void setUp() throws Exception {

        final RedirectingNumber redirectingNumber = isupFactory.createRedirectingNumber();
        redirectingNumber.setNatureOfAddresIndicator(RedirectingNumber._NAI_INTERNATIONAL_NUMBER);
        redirectingNumber.setNumberingPlanIndicator(RedirectingNumber._NPI_TELEX);
        redirectingNumber.setAddressRepresentationRestrictedIndicator(RedirectingNumber._APRI_RESTRICTED);
        redirectingNumber.setAddress("0048567234978");
        final RedirectingPartyIDCap redirectingPartyIDCap = capFactory.createRedirectingPartyIDCap(redirectingNumber);
        txRedirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(redirectingPartyIDCap);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRedirectingPartyNumberWrapper);
        TxRedirectingPartyNumberWrapper tx = (TxRedirectingPartyNumberWrapper) deserializeFromFile();

        assertTrue(txRedirectingPartyNumberWrapper.getAddress().equals(tx.getAddress()));
        assertTrue(txRedirectingPartyNumberWrapper.getNature().getValue() == tx.getNature().getValue());
        assertTrue(txRedirectingPartyNumberWrapper.getNumberingPlan().equals(tx.getNumberingPlan()));
        assertTrue(txRedirectingPartyNumberWrapper.getPresentation().equals(tx.getPresentation()));

    }

}
