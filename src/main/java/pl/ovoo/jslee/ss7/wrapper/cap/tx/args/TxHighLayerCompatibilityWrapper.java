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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;

/**
 * TxHighLayerCompatibilityWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxHighLayerCompatibilityWrapper implements HighLayerCompatibilityWrapper {

    private final HighLayerCompatibilityInap highLayerCompatibilityInap;

    public TxHighLayerCompatibilityWrapper(final HighLayerCompatibilityInap highLayerCompatibilityInap) {
        this.highLayerCompatibilityInap = highLayerCompatibilityInap;
    }

    @Override
    public boolean hasCharacteristics() throws Ss7WrapperException {
        try {
            return highLayerCompatibilityInap.getHighLayerCompatibility() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Characteristics getCharacteristics() throws Ss7WrapperException {
        try {
            return Characteristics.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getHighLayerCharIdentification());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public CodingStandard getCodingStandard() throws Ss7WrapperException {
        try {
            return CodingStandard.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getCodingStandard());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Interpretation getInterpretation() throws Ss7WrapperException {
        try {
            return Interpretation.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getInterpretation());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Presentation getPresentation() throws Ss7WrapperException {
        try {
            return Presentation.valueOf(highLayerCompatibilityInap.getHighLayerCompatibility().getPresentationMethod());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    public HighLayerCompatibilityInap getTxHighLayerCompatibilityInap() {
        return highLayerCompatibilityInap;
    }

	@Override
	public String toString() {
		return "TxHighLayerCompatibilityWrapper [highLayerCompatibilityInap=" + highLayerCompatibilityInap + "]";
	}
    
}
