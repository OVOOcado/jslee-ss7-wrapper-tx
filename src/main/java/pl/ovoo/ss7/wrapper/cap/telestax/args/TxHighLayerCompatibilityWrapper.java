/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
