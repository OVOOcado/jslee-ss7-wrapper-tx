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

package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxGenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxGenericNumberWrapperTest extends WrapperBaseTest {

    TxGenericNumberWrapper txGenericNumberWrapper;

    @Before
    public void setUp() throws Exception {

        GenericNumber genericNumber = isupFactory.createGenericNumber();
        genericNumber.setNumberingPlanIndicator(GenericNumberWrapper.NumberingPlan.ISDN.getValue());
        genericNumber.setNatureOfAddresIndicator(GenericNumberWrapper.Nature.NATIONAL.getValue());
        genericNumber.setAddress("0697234123");
        genericNumber.setAddressRepresentationRestrictedIndicator(GenericNumber._APRI_RESTRICTED);
        genericNumber.setNumberQualifierIndicator(GenericNumber._NQIA_CALLING_PARTY_NUMBER);
        genericNumber.setScreeningIndicator(GenericNumber._SI_USER_PROVIDED_VERIFIED_PASSED);

        txGenericNumberWrapper = new TxGenericNumberWrapper(genericNumber);

    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txGenericNumberWrapper);
        TxGenericNumberWrapper tx = (TxGenericNumberWrapper) deserializeFromFile();

        assertTrue(txGenericNumberWrapper.getTxGenericNumber().getNumberingPlanIndicator() == tx.getTxGenericNumber()
                .getNumberingPlanIndicator());
        assertTrue(txGenericNumberWrapper.getTxGenericNumber().getNatureOfAddressIndicator() == tx.getTxGenericNumber()
                .getNatureOfAddressIndicator());
        assertTrue(txGenericNumberWrapper.getTxGenericNumber().getScreeningIndicator() == tx.getTxGenericNumber()
                .getScreeningIndicator());
        assertTrue(txGenericNumberWrapper.getTxGenericNumber().getNumberQualifierIndicator() == tx.getTxGenericNumber()
                .getNumberQualifierIndicator());
        assertTrue(
                txGenericNumberWrapper.getTxGenericNumber().getAddress().equals(tx.getTxGenericNumber().getAddress()));
        assertTrue(txGenericNumberWrapper.getTxGenericNumber().getAddressRepresentationRestrictedIndicator() == tx
                .getTxGenericNumber().getAddressRepresentationRestrictedIndicator());
        assertTrue(txGenericNumberWrapper.getAddress().equals(tx.getAddress()));

    }

}
