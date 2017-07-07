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

package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.FTNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNSubaddressString;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.MAPPrivateExtension;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.SSCode;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPForwardingInfoWrapper;

public class TxMAPForwardingInfoWrapperTest extends WrapperBaseTest {

    TxMAPForwardingInfoWrapper txMAPForwardingInfoWrapper;

    @Before
    public void setUp() throws Exception {

        FTNAddressString ftnAddressString = mapParameterFactory.createFTNAddressString(
                AddressNature.national_significant_number, NumberingPlan.national, "0048214248124");
        MAPPrivateExtension mapPrivateExtension = mapParameterFactory.createMAPPrivateExtension(new long[] { 100 },
                new byte[] { 64 });
        ArrayList<MAPPrivateExtension> mapPrivateExtensions = new ArrayList<MAPPrivateExtension>(1);
        mapPrivateExtensions.add(mapPrivateExtension);
        MAPExtensionContainer mapExtensionContainer = mapParameterFactory
                .createMAPExtensionContainer(mapPrivateExtensions, new byte[] { 32 });

        ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(true, true, true,
                ExtForwOptionsForwardingReason.msBusy);
        ISDNSubaddressString isdnSubaddressString = mapParameterFactory.createISDNSubaddressString(new byte[] { 32 });
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.international_number, NumberingPlan.ISDN, "0048766243123");
        ExtSSStatus extSSStatus = mapParameterFactory.createExtSSStatus(true, false, true, false);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(BearerServiceCodeValue.allAlternateSpeech_DataCDS);
        ExtBasicServiceCode extBasicServiceCode = mapParameterFactory.createExtBasicServiceCode(extBearerServiceCode);
        ExtForwFeature extForwFeature = mapParameterFactory.createExtForwFeature(extBasicServiceCode, extSSStatus,
                isdnAddressString, isdnSubaddressString, extForwOptions, 1, mapExtensionContainer, ftnAddressString);
        ArrayList<ExtForwFeature> extForwFeatures = new ArrayList<ExtForwFeature>(1);
        extForwFeatures.add(extForwFeature);

        org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode ssCode = mapParameterFactory
                .createSSCode(SupplementaryCodeValue.allCallCompletionSS);
        ExtForwInfo extForwInfo = mapParameterFactory.createExtForwInfo(ssCode, extForwFeatures, mapExtensionContainer);
        txMAPForwardingInfoWrapper = new TxMAPForwardingInfoWrapper(extForwInfo);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMAPForwardingInfoWrapper);
        TxMAPForwardingInfoWrapper tx = (TxMAPForwardingInfoWrapper) deserializeFromFile();

        assertTrue(txMAPForwardingInfoWrapper.getTxExtForwInfo().getExtensionContainer().getPrivateExtensionList()
                .get(0).getData()[0] == tx.getTxExtForwInfo().getExtensionContainer().getPrivateExtensionList().get(0)
                        .getData()[0]);
        assertTrue(txMAPForwardingInfoWrapper.getTxExtForwInfo().getSsCode().getData() == tx.getTxExtForwInfo()
                .getSsCode().getData());
    }

}
