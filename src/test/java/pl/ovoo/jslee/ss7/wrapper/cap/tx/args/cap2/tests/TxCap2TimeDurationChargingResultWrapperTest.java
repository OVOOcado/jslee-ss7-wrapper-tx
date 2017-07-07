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

package pl.ovoo.ss7.wrapper.cap.tx.args.cap2.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.AChChargingAddress;
import org.mobicents.protocols.ss7.cap.api.primitives.CAPExtensions;
import org.mobicents.protocols.ss7.cap.api.primitives.CriticalityType;
import org.mobicents.protocols.ss7.cap.api.primitives.ExtensionField;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeInformation;
import org.mobicents.protocols.ss7.cap.service.circuitSwitchedCall.primitive.TimeInformationImpl;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.tx.args.cap2.TxCap2TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2TimeDurationChargingResultWrapperTest extends WrapperBaseTest {

    TxCap2TimeDurationChargingResultWrapper txCap2TimeDurationChargingResultWrapper;

    @Before
    public void setUp() throws Exception {

        final ReceivingSideID receivingSideID = capFactory.createReceivingSideID(LegType.leg1);
        final TimeInformation timeInformation = capFactory
                .createTimeInformation(TimeInformationImpl._ID_timeIfNoTariffSwitch);
        final ExtensionField extensionField = capFactory.createExtensionField(2, CriticalityType.typeIgnore,
                new byte[] { 64 });
        ArrayList<ExtensionField> extensionFields = new ArrayList<ExtensionField>(1);
        extensionFields.add(extensionField);
        final CAPExtensions capExtensions = capFactory.createCAPExtensions(extensionFields);
        final LegID legID = inapFactory.createLegID(true, LegType.leg2);
        final AChChargingAddress achChargingAddress = capFactory.createAChChargingAddress(legID);
        final TimeDurationChargingResult timeDurationChargingResult = capFactory.createTimeDurationChargingResult(
                receivingSideID, timeInformation, true, true, capExtensions, achChargingAddress);

        txCap2TimeDurationChargingResultWrapper = new TxCap2TimeDurationChargingResultWrapper(
                timeDurationChargingResult);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2TimeDurationChargingResultWrapper);
        TxCap2TimeDurationChargingResultWrapper tx = (TxCap2TimeDurationChargingResultWrapper) deserializeFromFile();

        assertTrue(txCap2TimeDurationChargingResultWrapper.getTxTimeDurationChargingResult().getAChChargingAddress()
                .getLegID().getSendingSideID().getCode() == tx.getTxTimeDurationChargingResult().getAChChargingAddress()
                        .getLegID().getSendingSideID().getCode());

    }

}
